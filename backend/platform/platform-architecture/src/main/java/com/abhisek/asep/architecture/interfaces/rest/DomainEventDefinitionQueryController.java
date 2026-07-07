package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.domainevent.query.dto.DomainEventDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.domainevent.query.service.DomainEventDefinitionQueryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/design/domain-events")
@RequiredArgsConstructor
@Tag(name = "Domain Event Query")
public class DomainEventDefinitionQueryController extends BaseController {

    private final DomainEventDefinitionQueryService service;

    @Operation(summary = "Get Domain Event")
    @GetMapping("/{domainEventId}")
    public ResponseEntity<ApiResponse<DomainEventDefinitionDetailsResponse>> getDomainEvent(@PathVariable("domainEventId") String domainEventId) {

        return ResponseEntity.ok(ApiResponse.success("Domain Event loaded successfully.", service.getDomainEvent(domainEventId)));

    }

    @Operation(summary = "List Domain Events")
    @GetMapping("/aggregate/{aggregateId}")
    public ResponseEntity<ApiResponse<List<DomainEventDefinitionDetailsResponse>>> getDomainEvents(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("Domain Events loaded successfully.", service.getDomainEvents(aggregateId)));

    }

}