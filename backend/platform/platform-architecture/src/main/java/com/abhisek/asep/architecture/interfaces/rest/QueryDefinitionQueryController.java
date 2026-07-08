package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.query.query.dto.QueryDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.query.query.service.QueryDefinitionQueryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/design/queries")
@RequiredArgsConstructor
@Tag(name = "Query Definition Query")
public class QueryDefinitionQueryController extends BaseController {

    private final QueryDefinitionQueryService service;

    @Operation(summary = "Get Query Definition")
    @GetMapping("/{queryDefinitionId}")
    public ResponseEntity<ApiResponse<QueryDefinitionDetailsResponse>>
    getQueryDefinition(@PathVariable("queryDefinitionId") String queryDefinitionId) {

        return ResponseEntity.ok(ApiResponse.success("Query Definition loaded successfully.",
                service.getQueryDefinition(queryDefinitionId)));

    }

    @Operation(summary = "List Query Definitions")
    @GetMapping("/aggregate/{aggregateId}")
    public ResponseEntity<ApiResponse<List<QueryDefinitionDetailsResponse>>>
    getQueryDefinitions(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("Query Definitions loaded successfully.",
                service.getQueryDefinitions(aggregateId)));

    }

}