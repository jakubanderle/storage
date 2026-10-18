package cz.anderle.mizar.storage.services;

import cz.anderle.mizar.storage.config.StorageProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StorageService {

    private final StorageProperties storageProperties;

    public StorageService(StorageProperties storageProperties) {
        this.storageProperties = storageProperties;
    }

//    public StorageInfoDTO getStorageInfo() {
//        log.info("Getting storage info");
//        throw new UnsupportedOperationException("Not implemented yet");
//    }
}
