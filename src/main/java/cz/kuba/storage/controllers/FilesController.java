package cz.kuba.storage.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import cz.kuba.storage.models.FileListResponseDTO;
import cz.kuba.storage.models.FileMetadataDTO;
import cz.kuba.storage.services.FilesService;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping("/v1/files")
public class FilesController {

    private final FilesService fileService;

    public FilesController(FilesService fileService) {
        this.fileService = fileService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public FileListResponseDTO getFiles(
            @RequestParam @DefaultValue("100") int limit,
            @RequestParam @DefaultValue("0") int offset,
            @RequestParam UUID directoryId) {
        return fileService.getFiles(limit, offset, directoryId);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public FileMetadataDTO upload(
            @RequestHeader("X-File_Name") String fileName,
            @RequestHeader("X-Directory-Id") UUID directoryId,
            @RequestHeader("X-Content-SHA5256") String contentSHA5256,
            @RequestBody InputStream input) {
        return fileService.upload(fileName, directoryId, contentSHA5256, input);
    };

    @GetMapping(value = "/{fileId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public FileMetadataDTO getFileMetadata(
            @PathVariable UUID fileId) {
        return fileService.getFileMetadata(fileId);
    }

    @PatchMapping(value = "/{fileId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public FileMetadataDTO updateFileMetadata(
            @PathVariable UUID fileId) {
        return fileService.updateFileMetadata(fileId);
    }

    @DeleteMapping(value = "/{fileId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFile(
            @PathVariable UUID fileId) {
        fileService.deleteFile(fileId);
    }

    @GetMapping(value = "/{fileId}/content", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<StreamingResponseBody> getFileContent(
            @PathVariable UUID fileId) {
        FileMetadataDTO metadata = fileService.getFileMetadata(fileId);

        StreamingResponseBody stream = output -> {
            try (InputStream input = fileService.getFileContent(fileId)) {
                input.transferTo(output);
            }
        };

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + metadata.name() + "\"")
                .body(stream);
    }
}
