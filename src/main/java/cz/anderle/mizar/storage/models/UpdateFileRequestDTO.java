package cz.kuba.storage.models;

import java.util.UUID;

import org.jspecify.annotations.NullMarked;

import jakarta.annotation.Nullable;

@NullMarked
public record UpdateFileRequestDTO(
        String name,
        @Nullable UUID directoryId) {
}
