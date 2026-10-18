package cz.anderle.mizar.storage.controllers;

import cz.anderle.mizar.storage.api.StorageApi;
import cz.anderle.mizar.storage.api.model.StorageInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/storage")
public class StorageController implements StorageApi {

    @Override
    public ResponseEntity<StorageInfo> getStorageInfo() {
        return StorageApi.super.getStorageInfo();
    }
}
