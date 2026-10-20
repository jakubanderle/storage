package cz.anderle.fabric.storage.controllers;

import cz.anderle.fabric.storage.api.DirectoryApi;
import cz.anderle.fabric.storage.api.model.CreateDirectoryRequest;
import cz.anderle.fabric.storage.api.model.DirectoryMetadata;
import cz.anderle.fabric.storage.api.model.UpdateItemRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/directories")
public class DirectoryController implements DirectoryApi {

    @Override
    public ResponseEntity<DirectoryMetadata> createDirectory(CreateDirectoryRequest createDirectoryRequest) {
        return DirectoryApi.super.createDirectory(createDirectoryRequest);
    }

    @Override
    public ResponseEntity<Void> deleteDirectory(UUID id) {
        return DirectoryApi.super.deleteDirectory(id);
    }

    @Override
    public ResponseEntity<DirectoryMetadata> getDirectory(UUID id) {
        return DirectoryApi.super.getDirectory(id);
    }

    @Override
    public ResponseEntity<DirectoryMetadata> updateDirectory(UUID id, UpdateItemRequest updateFileRequest) {
        return DirectoryApi.super.updateDirectory(id, updateFileRequest);
    }
}
