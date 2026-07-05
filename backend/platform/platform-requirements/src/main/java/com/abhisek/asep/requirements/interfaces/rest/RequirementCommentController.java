package com.abhisek.asep.requirements.interfaces.rest;

import com.abhisek.asep.core.web.BaseController;
import com.abhisek.asep.requirements.application.dto.request.AddRequirementCommentRequest;
import com.abhisek.asep.requirements.application.dto.response.RequirementCommentResponse;
import com.abhisek.asep.requirements.application.usecase.AddRequirementCommentUseCase;
import com.abhisek.asep.requirements.application.usecase.DeleteRequirementCommentUseCase;
import com.abhisek.asep.requirements.application.usecase.ListRequirementCommentsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/requirements", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Requirement Comments", description = "APIs for managing requirement comments")
@SecurityRequirement(name = "Bearer Authentication")
public class RequirementCommentController extends BaseController {

    private final AddRequirementCommentUseCase addRequirementCommentUseCase;
    private final ListRequirementCommentsUseCase listRequirementCommentsUseCase;
    private final DeleteRequirementCommentUseCase deleteRequirementCommentUseCase;

    @Operation(summary = "Add Requirement Comment", description = "Adds a new comment to a requirement.")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Comment added successfully"), @ApiResponse(responseCode = "400", description = "Validation failed", content = @Content), @ApiResponse(responseCode = "404", description = "Requirement not found", content = @Content)})
    @PostMapping(value = "/{requirementId}/comments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<com.abhisek.asep.common.response.ApiResponse<RequirementCommentResponse>> addComment(

            @Parameter(description = "Requirement Identifier", required = true, example = "REQ-1001") @PathVariable String requirementId,

            @Valid @RequestBody AddRequirementCommentRequest request) {

        return created("Comment added successfully", addRequirementCommentUseCase.execute(requirementId, request));
    }

    @Operation(summary = "Get Requirement Comments", description = "Returns all comments for a requirement.")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Comments retrieved successfully"), @ApiResponse(responseCode = "404", description = "Requirement not found", content = @Content)})
    @GetMapping("/{requirementId}/comments")
    public ResponseEntity<com.abhisek.asep.common.response.ApiResponse<List<RequirementCommentResponse>>> getComments(

            @Parameter(description = "Requirement Identifier", required = true, example = "REQ-1001") @PathVariable String requirementId) {

        return ok("Comments retrieved successfully", listRequirementCommentsUseCase.execute(requirementId));
    }

    @Operation(summary = "Delete Requirement Comment", description = "Deletes an existing requirement comment.")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Comment deleted successfully"), @ApiResponse(responseCode = "404", description = "Comment not found", content = @Content)})
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<com.abhisek.asep.common.response.ApiResponse<Void>> deleteComment(

            @Parameter(description = "Comment Identifier", required = true, example = "COM-1001") @PathVariable String commentId) {

        deleteRequirementCommentUseCase.execute(commentId);

        return deleted("Comment deleted successfully");
    }
}