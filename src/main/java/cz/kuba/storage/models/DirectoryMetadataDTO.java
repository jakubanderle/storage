package cz.kuba.storage.models;

import java.time.Instant;
import java.util.UUID;

import org.jspecify.annotations.NullMarked;

import jakarta.annotation.Nullable;

@NullMarked
public record DirectoryMetadataDTO(
        UUID id,
        String name,
        @Nullable UUID parentId,
        Instant createdAt) {
}
