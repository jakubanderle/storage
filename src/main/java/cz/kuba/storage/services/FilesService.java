package cz.kuba.storage.services;

import java.io.InputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;

import cz.kuba.storage.config.StorageProperties;
import cz.kuba.storage.models.FileListResponseDTO;
import cz.kuba.storage.models.FileMetadataDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
        log.info("Getting files with limit: {}, offset: {}, directoryId: {}", limit, offset, directoryId);
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public FileMetadataDTO upload(
            String fileName,
            UUID directoryId,
            String contentSHA5256,
            InputStream input) {
        log.info("Uploading file: {}, directoryId: {}, contentSHA5256: {}", fileName, directoryId, contentSHA5256);
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public FileMetadataDTO getFileMetadata(
            UUID fileId) {
        log.info("Getting file metadata for fileId: {}", fileId);
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public FileMetadataDTO updateFileMetadata(
            UUID fileId) {
        log.info("Updating file metadata for fileId: {}", fileId);
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void deleteFile(
            UUID fileId) {
        log.info("Deleting file with fileId: {}", fileId);
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public InputStream getFileContent(
            UUID fileId) {
        log.info("Getting file content for fileId: {}", fileId);
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
