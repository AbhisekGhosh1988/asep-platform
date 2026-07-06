package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.dto.request.CreateArchitectureRequest;
import com.abhisek.asep.architecture.application.dto.request.UpdateArchitectureRequest;
import com.abhisek.asep.architecture.application.dto.response.ArchitectureResponse;
import com.abhisek.asep.architecture.application.usecase.CreateArchitectureUseCase;
import com.abhisek.asep.architecture.application.usecase.DeleteArchitectureUseCase;
import com.abhisek.asep.architecture.application.usecase.GetArchitectureUseCase;
import com.abhisek.asep.architecture.application.usecase.ListArchitecturesUseCase;
import com.abhisek.asep.architecture.application.usecase.UpdateArchitectureUseCase;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/architectures")
@RequiredArgsConstructor
@Tag(name = "Architecture Management", description = "Architecture CRUD Operations")
@SecurityRequirement(name = "Bearer Authentication")
public class ArchitectureController extends BaseController {

    private final CreateArchitectureUseCase createArchitectureUseCase;
    private final UpdateArchitectureUseCase updateArchitectureUseCase;
    private final GetArchitectureUseCase getArchitectureUseCase;
    private final DeleteArchitectureUseCase deleteArchitectureUseCase;
    private final ListArchitecturesUseCase listArchitecturesUseCase;

    @Operation(summary = "Create Architecture", description = "Creates a new architecture for a project.")
    @ApiResponses({@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Architecture created successfully"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid request", content = @Content)})
    @PostMapping
    public ResponseEntity<ApiResponse<ArchitectureResponse>> createArchitecture(@Valid @RequestBody CreateArchitectureRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Architecture created successfully", createArchitectureUseCase.execute(request)));

    }

    @Operation(summary = "Get Architecture", description = "Returns architecture details.")
    @ApiResponses({@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Architecture found"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Architecture not found", content = @Content)})
    @GetMapping("/{architectureId}")
    public ResponseEntity<ApiResponse<ArchitectureResponse>> getArchitecture(

            @Parameter(description = "Architecture Id") @PathVariable String architectureId) {

        return ResponseEntity.ok(ApiResponse.success("Architecture retrieved successfully", getArchitectureUseCase.execute(architectureId)));

    }

    @Operation(summary = "Update Architecture", description = "Updates architecture.")
    @PutMapping("/{architectureId}")
    public ResponseEntity<ApiResponse<ArchitectureResponse>> updateArchitecture(

            @Parameter(description = "Architecture Id") @PathVariable String architectureId,

            @Valid @RequestBody UpdateArchitectureRequest request) {

        return ResponseEntity.ok(ApiResponse.success("Architecture updated successfully", updateArchitectureUseCase.execute(architectureId, request)));

    }

    @Operation(summary = "Delete Architecture", description = "Deletes architecture.")
    @DeleteMapping("/{architectureId}")
    public ResponseEntity<ApiResponse<Void>> deleteArchitecture(

            @Parameter(description = "Architecture Id") @PathVariable String architectureId) {

        deleteArchitectureUseCase.execute(architectureId);

        return ResponseEntity.ok(ApiResponse.success("Architecture deleted successfully", null));

    }

    @Operation(summary = "List Architectures", description = "Returns all architectures for a project.")
    @GetMapping("/project/{projectId}")
    public ResponseEntity<ApiResponse<List<ArchitectureResponse>>> listArchitectures(

            @Parameter(description = "Project Id") @PathVariable String projectId) {

        return ResponseEntity.ok(ApiResponse.success("Architectures retrieved successfully", listArchitecturesUseCase.execute(projectId)));

    }

}