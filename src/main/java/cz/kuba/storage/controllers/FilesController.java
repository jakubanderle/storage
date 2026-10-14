package cz.kuba.storage.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import cz.kuba.storage.models.FileListResponseDTO;
import cz.kuba.storage.models.FileMetadataDTO;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping("/v1/files")
public class FilesController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FileListResponseDTO> getFiles(
            @RequestParam @DefaultValue("100") int limit,
            @RequestParam @DefaultValue("0") int offset,
            @RequestParam UUID directoryId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<FileMetadataDTO> upload(
            @RequestHeader("X-File_Name") String fileName,
            @RequestHeader("X-Directory-Id") UUID directoryId,
            @RequestHeader("X-Content-SHA5256") String contentSHA5256,
            @RequestBody InputStream input) {
        Path destination = Path.of("/mnt/storage/uploads", directoryId.toString(), fileName);

        Files.copy(input, destination);
    }

    @GetMapping(value = "/{fileId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FileMetadataDTO> getFileMetadata(
            @PathVariable UUID fileId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PatchMapping(value = "/{fileId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FileMetadataDTO> updateFileMetadata(
            @PathVariable UUID fileId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @DeleteMapping(value = "/{fileId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteFile(
            @PathVariable UUID fileId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping(value = "/{fileId}/content", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<StreamingResponseBody> getFileContent(
            @PathVariable UUID fileId) {
        FileMetadataDTO metadata = fileService.getMetadata(fileId);

        StreamingResponseBody stream = output -> {
            try (InputStream input = fileService.openStream(fileId)) {
                input.transferTo(output);
            }
        };

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + metadata.getName() + "\"")
                .body(stream);
    }
}
