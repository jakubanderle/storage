package cz.anderle.fabric.storage.services;

import cz.anderle.fabric.storage.config.StorageProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DirectoryService {

    private final StorageProperties storageProperties;

    public DirectoryService(StorageProperties storageProperties) {
        this.storageProperties = storageProperties;
    }

//    public DirectoryMetadataDTO createDirectory(CreateDirectoryRequestDTO request) {
//        log.info("Creating directory with name: {}, parentId: {}", request.name(), request.parentId());
//        throw new UnsupportedOperationException("Not implemented yet");
//    }
//
//    public DirectoryMetadataDTO getDirectoryMetadata(UUID directoryId) {
//        log.info("Getting directory metadata for directoryId: {}", directoryId);
//        throw new UnsupportedOperationException("Not implemented yet");
//    }
//
//    public DirectoryMetadataDTO updateDirectoryMetadata(UpdateFileRequestDTO request) {
//        log.info("Updating directory metadata for directoryId: {}", request.directoryId());
//        throw new UnsupportedOperationException("Not implemented yet");
//    }
//
//    public void deleteDirectory(UUID directoryId) {
//        log.info("Deleting directory with directoryId: {}", directoryId);
//        throw new UnsupportedOperationException("Not implemented yet");
//    }
}
