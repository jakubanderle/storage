package cz.kuba.storage.services;

import java.io.InputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;

import cz.kuba.storage.config.StorageProperties;
import cz.kuba.storage.models.FileListResponseDTO;
import cz.kuba.storage.models.FileMetadataDTO;

@Service
public class FilesService {

    private final StorageProperties storageProperties;

    FilesService(StorageProperties storageProperties) {
        this.storageProperties = storageProperties;
    }

    public FileListResponseDTO getFiles(
            int limit,
            int offset,
            UUID directoryId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public FileMetadataDTO upload(
            String fileName,
            UUID directoryId,
            String contentSHA5256,
            InputStream input) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public FileMetadataDTO getFileMetadata(
            UUID fileId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public FileMetadataDTO updateFileMetadata(
            UUID fileId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void deleteFile(
            UUID fileId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public InputStream getFileContent(
            UUID fileId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
