-- Migration user
CREATE
USER storage_liquibase
    WITH PASSWORD 'liquibase';

-- Application user
CREATE
USER storage
    WITH PASSWORD 'storage';

-- Database
CREATE
DATABASE storage
    OWNER storage_liquibase;

GRANT CONNECT
ON DATABASE storage TO storage;

-- Switch to the application database
\connect storage

-- Schema permissions
GRANT USAGE ON SCHEMA public TO storage;

-- Existing tables
GRANT
SELECT,
INSERT
,
UPDATE,
DELETE
ON ALL TABLES IN SCHEMA public TO storage;

-- Existing sequences
GRANT
USAGE,
SELECT
ON ALL SEQUENCES IN SCHEMA public TO storage;

-- Future tables created by Liquibase
ALTER
DEFAULT PRIVILEGES
    FOR ROLE storage_liquibase
    IN SCHEMA public
    GRANT
SELECT,
INSERT
,
UPDATE,
DELETE
ON TABLES TO storage;

-- Future sequences created by Liquibase
ALTER
DEFAULT PRIVILEGES
    FOR ROLE storage_liquibase
    IN SCHEMA public
    GRANT USAGE,
SELECT
ON SEQUENCES TO storage;
