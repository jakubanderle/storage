package cz.kuba.storage.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import cz.kuba.storage.config.StorageProperties;
import cz.kuba.storage.models.CreateDirectoryRequestDTO;
import cz.kuba.storage.models.DirectoryMetadataDTO;
import cz.kuba.storage.models.UpdateFileRequestDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Service 
public class DirectoriesService {

    private final StorageProperties storageProperties;

    public DirectoriesService(StorageProperties storageProperties) {
        this.storageProperties = storageProperties;
    }

    public DirectoryMetadataDTO createDirectory(CreateDirectoryRequestDTO request) {
        log.info("Creating directory with name: {}, parentId: {}", request.name(), request.parentId());
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public DirectoryMetadataDTO getDirectoryMetadata(UUID directoryId) {
        log.info("Getting directory metadata for directoryId: {}", directoryId);
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public DirectoryMetadataDTO updateDirectoryMetadata(UpdateFileRequestDTO request) {
        log.info("Updating directory metadata for directoryId: {}", request.directoryId());
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void deleteDirectory(UUID directoryId) {
        log.info("Deleting directory with directoryId: {}", directoryId);
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
