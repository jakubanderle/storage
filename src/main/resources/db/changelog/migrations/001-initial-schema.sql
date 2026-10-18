--liquibase formatted sql

--changeset jakub:001-initial-schema

CREATE TABLE metadata
(
    id          UUID PRIMARY KEY,
    description TEXT,
    custom      JSONB,

    CONSTRAINT chk_metadata_custom
        CHECK (
            custom IS NULL
                OR jsonb_typeof(custom) = 'object'
            )
);

CREATE TABLE directory
(
    id          UUID PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    parent_id   UUID REFERENCES directory (id)
        ON DELETE RESTRICT,
    created_at  TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    metadata_id UUID UNIQUE REFERENCES metadata (id),

    CONSTRAINT chk_directory_name
        CHECK (length(trim(name)) > 0),

    CONSTRAINT chk_directory_not_self_parent
        CHECK (parent_id IS DISTINCT FROM id
)
    );

CREATE TABLE file
(
    id           UUID PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    directory_id UUID REFERENCES directory (id)
        ON DELETE RESTRICT,
    size         BIGINT       NOT NULL,
    content_type VARCHAR(255),
    checksum     CHAR(64)     NOT NULL,
    created_at   TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    updated_at   TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    metadata_id  UUID UNIQUE REFERENCES metadata (id),

    CONSTRAINT chk_file_name
        CHECK (length(trim(name)) > 0),

    CONSTRAINT chk_file_size
        CHECK (size >= 0
) ,

    CONSTRAINT chk_file_checksum
        CHECK (checksum ~ '^[a-fA-F0-9]{64}$')
);

CREATE TABLE tag
(
    metadata_id UUID         NOT NULL
        REFERENCES metadata (id) ON DELETE CASCADE,
    value       VARCHAR(100) NOT NULL,

    PRIMARY KEY (metadata_id, value),

    CONSTRAINT chk_tag_value
        CHECK (length(trim(value)) > 0)
);

-- Unique names within the same parent directory,
-- including the virtual root.

CREATE UNIQUE INDEX uq_directory_parent_name
    ON directory (parent_id, name) NULLS NOT DISTINCT;

CREATE UNIQUE INDEX uq_file_directory_name
    ON file (directory_id, name) NULLS NOT DISTINCT;

-- Directory browsing.

CREATE INDEX idx_directory_parent_id
    ON directory (parent_id);

CREATE INDEX idx_file_directory_id
    ON file (directory_id);

-- Tag filtering.

CREATE INDEX idx_tag_value
    ON tag (value);
