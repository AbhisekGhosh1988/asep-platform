package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.entity.ai.dto.EntityDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.entity.service.EntityDiscoveryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/design/entities")
@RequiredArgsConstructor
@Tag(name = "Entity Discovery")
public class EntityDiscoveryController extends BaseController {

    private final EntityDiscoveryService discoveryService;

    @Operation(summary = "Discover Entities")
    @PostMapping("/discover/{aggregateId}")
    public ResponseEntity<ApiResponse<EntityDiscoveryResponse>> discover(@PathVariable("aggregateId") String aggregateId) {
        return ResponseEntity.ok(ApiResponse.success("Entities discovered successfully.", discoveryService.discover(aggregateId)));

    }

}