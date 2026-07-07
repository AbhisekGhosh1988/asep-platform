package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.repository.query.dto.RepositoryDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.repository.query.service.RepositoryDefinitionQueryService;
import com.abhisek.asep.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/design/repositories")
@RequiredArgsConstructor
@Tag(name = "Repository Definition Query")
public class RepositoryDefinitionQueryController {

    private final RepositoryDefinitionQueryService service;

    @Operation(summary = "Get Repository Definition")
    @GetMapping("/{repositoryDefinitionId}")
    public ResponseEntity<ApiResponse<RepositoryDefinitionDetailsResponse>>
    getRepositoryDefinition(@PathVariable("repositoryDefinitionId") String repositoryDefinitionId) {

        return ResponseEntity.ok(ApiResponse.success("Repository Definition loaded successfully.", service.getRepositoryDefinition(repositoryDefinitionId)));

    }

    @Operation(summary = "List Repository Definitions")
    @GetMapping("/aggregate/{aggregateId}")
    public ResponseEntity<ApiResponse<List<RepositoryDefinitionDetailsResponse>>>
    getRepositoryDefinitions(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("Repository Definitions loaded successfully.", service.getRepositoryDefinitions(aggregateId)));

    }

}