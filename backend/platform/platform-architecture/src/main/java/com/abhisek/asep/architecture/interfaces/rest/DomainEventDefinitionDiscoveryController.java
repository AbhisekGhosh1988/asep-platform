package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.domainevent.ai.dto.DomainEventDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.domainevent.service.DomainEventDefinitionDiscoveryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/design/domain-events")
@RequiredArgsConstructor
@Tag(name = "Domain Event Discovery")
public class DomainEventDefinitionDiscoveryController extends BaseController {

    private final DomainEventDefinitionDiscoveryService service;

    @Operation(summary = "Discover Domain Events")
    @PostMapping("/discover/{aggregateId}")
    public ResponseEntity<ApiResponse<DomainEventDefinitionDiscoveryResponse>> discover(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("Domain Events discovered successfully.", service.discover(aggregateId)));

    }

}