package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.attribute.ai.dto.AttributeDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.attribute.service.AttributeDiscoveryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/design/attributes")
@RequiredArgsConstructor
@Tag(name = "Attribute Discovery")
public class AttributeDiscoveryController extends BaseController {

    private final AttributeDiscoveryService discoveryService;

    @Operation(summary = "Discover Attributes")
    @PostMapping("/discover/{entityId}")
    public ResponseEntity<ApiResponse<AttributeDiscoveryResponse>> discover(@PathVariable("entityId") String entityId) {
        return ResponseEntity.ok(ApiResponse.success("Attributes discovered successfully.",
                discoveryService.discover(entityId)));

    }
}