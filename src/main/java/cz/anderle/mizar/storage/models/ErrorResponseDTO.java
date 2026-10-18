package cz.kuba.storage.models;

import org.jspecify.annotations.NullMarked;

@NullMarked
public record ErrorResponseDTO(
        String title,
        Integer status,
        String detail) {
}
