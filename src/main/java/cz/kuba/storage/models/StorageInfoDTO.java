package cz.kuba.storage.models;

import org.jspecify.annotations.NullMarked;

@NullMarked
public record StorageInfoDTO(
        Integer totalBytes,
        Integer usedBytes,
        Integer freeBytes) {
}
