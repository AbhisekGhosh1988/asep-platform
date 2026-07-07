package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.repository.ai.dto.RepositoryDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.repository.service.RepositoryDefinitionDiscoveryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/design/repositories")
@RequiredArgsConstructor
@Tag(name = "Repository Definition Discovery")
public class RepositoryDefinitionDiscoveryController extends BaseController {

    private final RepositoryDefinitionDiscoveryService discoveryService;

    @Operation(summary = "Discover Repository Definitions")
    @PostMapping("/discover/{aggregateId}")
    public ResponseEntity<ApiResponse<RepositoryDefinitionDiscoveryResponse>> discover(
            @PathVariable String aggregateId) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Repository definitions discovered successfully.",
                        discoveryService.discover(aggregateId)));

    }

}