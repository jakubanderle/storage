package cz.kuba.storage.models;

import java.util.List;

import org.jspecify.annotations.NullMarked;

@NullMarked
public record FileListResponseDTO(
        List<FileMetadataDTO> files,
        Integer total) {
}
