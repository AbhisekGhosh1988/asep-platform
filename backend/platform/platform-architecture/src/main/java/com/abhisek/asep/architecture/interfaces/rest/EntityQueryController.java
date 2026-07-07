package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.entity.query.dto.EntityDetailsResponse;
import com.abhisek.asep.architecture.application.design.entity.query.service.EntityQueryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/design/entities")
@RequiredArgsConstructor
@Tag(name = "Entity Query")
public class EntityQueryController extends BaseController {

    private final EntityQueryService service;

    @Operation(summary = "Get Entity")
    @GetMapping("/{entityId}")
    public ResponseEntity<ApiResponse<EntityDetailsResponse>> getEntity(@PathVariable("entityId") String entityId) {

        return ResponseEntity.ok(ApiResponse.success("Entity loaded successfully.", service.getEntity(entityId)));

    }

    @Operation(summary = "List Entities")
    @GetMapping("/aggregate/{aggregateId}")
    public ResponseEntity<ApiResponse<List<EntityDetailsResponse>>> getEntities(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("Entities loaded successfully.", service.getEntities(aggregateId)));

    }

}