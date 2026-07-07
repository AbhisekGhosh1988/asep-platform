package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.relationship.query.dto.RelationshipDetailsResponse;
import com.abhisek.asep.architecture.application.design.relationship.query.service.RelationshipQueryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/design/relationships")
@RequiredArgsConstructor
@Tag(name = "Relationship Query")
public class RelationshipQueryController extends BaseController {

    private final RelationshipQueryService service;

    @Operation(summary = "Get Relationship")
    @GetMapping("/{relationshipId}")
    public ResponseEntity<ApiResponse<RelationshipDetailsResponse>> getRelationship(@PathVariable String relationshipId) {

        return ResponseEntity.ok(ApiResponse.success("Relationship loaded successfully.", service.getRelationship(relationshipId)));

    }

    @Operation(summary = "List Relationships")
    @GetMapping("/entity/{sourceEntityId}")
    public ResponseEntity<ApiResponse<List<RelationshipDetailsResponse>>> getRelationships(@PathVariable String sourceEntityId) {

        return ResponseEntity.ok(ApiResponse.success("Relationships loaded successfully.", service.getRelationships(sourceEntityId)));

    }

}