package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.domainservice.ai.dto.DomainServiceDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.domainservice.service.DomainServiceDefinitionDiscoveryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/design/domain-services")
@RequiredArgsConstructor
@Tag(name = "Domain Service Discovery")
public class DomainServiceDefinitionDiscoveryController extends BaseController {

    private final DomainServiceDefinitionDiscoveryService service;

    @Operation(summary = "Discover Domain Services")
    @PostMapping("/discover/{aggregateId}")
    public ResponseEntity<ApiResponse<DomainServiceDefinitionDiscoveryResponse>>
    discover(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("Domain Services discovered successfully.",
                service.discover(aggregateId)));

    }

}