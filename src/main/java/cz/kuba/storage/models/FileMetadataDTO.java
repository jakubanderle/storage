package cz.kuba.storage.models;

import java.time.Instant;
import java.util.UUID;

import org.jspecify.annotations.NullMarked;

import jakarta.annotation.Nullable;

@NullMarked
public record FileMetadataDTO(
        UUID id,
        String name,
        @Nullable UUID directoryId,
        Integer size,
        @Nullable String contentType,
        String checksum,
        Instant createdAt,
        @Nullable Instant updatedAt) {
}
