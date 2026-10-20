package cz.anderle.fabric.storage.controllers;

import cz.anderle.fabric.storage.api.FileApi;
import cz.anderle.fabric.storage.api.model.FileListResponse;
import cz.anderle.fabric.storage.api.model.FileMetadata;
import cz.anderle.fabric.storage.api.model.UpdateItemRequest;
import cz.anderle.fabric.storage.services.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/files")
public class FileController implements FileApi {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public ResponseEntity<FileListResponse> listFiles(UUID directoryId, Integer limit, Integer offset) {
        return FileApi.super.listFiles(directoryId, limit, offset);
    }

    @Override
    public ResponseEntity<FileMetadata> updateFile(UUID id, UpdateItemRequest updateFileRequest) {
        return FileApi.super.updateFile(id, updateFileRequest);
    }

    @Override
    public ResponseEntity<FileMetadata> uploadFile(String xFileName, UUID xDirectoryId, String xContentSHA256) {
        return FileApi.super.uploadFile(xFileName, xDirectoryId, xContentSHA256);
    }

    @Override
    public ResponseEntity<Void> downloadFile(UUID id) {
        return FileApi.super.downloadFile(id);
//        FileMetadata metadata = fileService.getFileMetadata(id);
//
//        StreamingResponseBody stream = output -> {
//            try (InputStream input = fileService.getFileContent(fileId)) {
//                input.transferTo(output);
//            }
//        };
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .header(HttpHeaders.CONTENT_DISPOSITION,
//                        "attachment; filename=\"" + metadata.name() + "\"")
//                .body(stream);
    }

    @Override
    public ResponseEntity<FileMetadata> getFile(UUID id) {
        return FileApi.super.getFile(id);
    }
}
