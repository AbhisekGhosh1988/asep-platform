package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.relationship.ai.dto.RelationshipDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.relationship.service.RelationshipDiscoveryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/design/relationships")
@RequiredArgsConstructor
@Tag(name = "Relationship Discovery")
public class RelationshipDiscoveryController extends BaseController {

    private final RelationshipDiscoveryService discoveryService;

    @Operation(summary = "Discover Relationships")
    @PostMapping("/discover/{aggregateId}")
    public ResponseEntity<ApiResponse<RelationshipDiscoveryResponse>> discover(
            @PathVariable String aggregateId) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Relationships discovered successfully.",
                        discoveryService.discover(aggregateId)));

    }

}