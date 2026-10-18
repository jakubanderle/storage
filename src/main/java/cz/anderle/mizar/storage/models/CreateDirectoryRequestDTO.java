package cz.kuba.storage.models;

import java.util.UUID;

import org.jspecify.annotations.NullMarked;

import jakarta.annotation.Nonnull;

@NullMarked
public record CreateDirectoryRequestDTO(
        String name,
        @Nonnull UUID parentId) {

}
