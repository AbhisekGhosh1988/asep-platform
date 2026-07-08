package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.query.ai.dto.QueryDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.query.service.QueryDefinitionDiscoveryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/design/queries")
@RequiredArgsConstructor
@Tag(name = "Query Discovery")
public class QueryDefinitionDiscoveryController extends BaseController {

    private final QueryDefinitionDiscoveryService service;

    @Operation(summary = "Discover Queries")
    @PostMapping("/discover/{aggregateId}")
    public ResponseEntity<ApiResponse<QueryDefinitionDiscoveryResponse>>
    discover(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("Queries discovered successfully.",
                service.discover(aggregateId)));

    }

}