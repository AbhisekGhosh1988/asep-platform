package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.domainservice.query.dto.DomainServiceDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.domainservice.query.service.DomainServiceDefinitionQueryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/design/domain-services")
@RequiredArgsConstructor
@Tag(name = "Domain Service Query")
public class DomainServiceDefinitionQueryController extends BaseController {

    private final DomainServiceDefinitionQueryService service;

    @Operation(summary = "Get Domain Service")
    @GetMapping("/{domainServiceId}")
    public ResponseEntity<ApiResponse<DomainServiceDefinitionDetailsResponse>>
    getDomainService(@PathVariable("domainServiceId") String domainServiceId) {

        return ResponseEntity.ok(ApiResponse.success("Domain Service loaded successfully.",
                service.getDomainService(domainServiceId)));

    }

    @Operation(summary = "List Domain Services")
    @GetMapping("/aggregate/{aggregateId}")
    public ResponseEntity<ApiResponse<List<DomainServiceDefinitionDetailsResponse>>>
    getDomainServices(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("Domain Services loaded successfully.",
                service.getDomainServices(aggregateId)));

    }

}