package com.abhisek.asep.requirements.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import com.abhisek.asep.requirements.application.dto.response.RequirementAttachmentResponse;
import com.abhisek.asep.requirements.application.usecase.DeleteRequirementAttachmentUseCase;
import com.abhisek.asep.requirements.application.usecase.DownloadRequirementAttachmentUseCase;
import com.abhisek.asep.requirements.application.usecase.ListRequirementAttachmentsUseCase;
import com.abhisek.asep.requirements.application.usecase.UploadRequirementAttachmentUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/requirements", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Requirement Attachments", description = "Manage requirement attachments")
@SecurityRequirement(name = "Bearer Authentication")
public class RequirementAttachmentController extends BaseController {

    private final UploadRequirementAttachmentUseCase uploadUseCase;
    private final ListRequirementAttachmentsUseCase listUseCase;
    private final DownloadRequirementAttachmentUseCase downloadUseCase;
    private final DeleteRequirementAttachmentUseCase deleteUseCase;

    @Operation(summary = "Upload attachment")
    @ApiResponses({@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Uploaded"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid request", content = @Content)})
    @PostMapping(value = "/{requirementId}/attachments", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<RequirementAttachmentResponse>> upload(

            @PathVariable String requirementId,

            @RequestPart("file") MultipartFile file,

            @RequestParam @NotBlank String uploadedBy) {

        return created("Attachment uploaded successfully", uploadUseCase.execute(requirementId, file, uploadedBy));
    }

    @Operation(summary = "List attachments")
    @GetMapping("/{requirementId}/attachments")
    public ResponseEntity<ApiResponse<List<RequirementAttachmentResponse>>> list(

            @PathVariable String requirementId) {

        return ok("Attachments retrieved successfully", listUseCase.execute(requirementId));
    }

    @Operation(summary = "Download attachment")
    @GetMapping("/attachments/{attachmentId}/download")
    public ResponseEntity<Resource> download(

            @Parameter(description = "Attachment Id") @PathVariable String attachmentId) {

        Resource resource = downloadUseCase.execute(attachmentId);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment().filename(resource.getFilename()).build().toString()).body(resource);
    }

    @Operation(summary = "Delete attachment")
    @DeleteMapping("/attachments/{attachmentId}")
    public ResponseEntity<ApiResponse<Void>> delete(

            @PathVariable String attachmentId) {

        deleteUseCase.execute(attachmentId);

        return deleted("Attachment deleted successfully");
    }

}