package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.query.dto.AggregateDetailsResponse;
import com.abhisek.asep.architecture.application.design.query.service.AggregateQueryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/design/aggregates")
@RequiredArgsConstructor
@Tag(name = "Aggregate Query")
public class AggregateQueryController extends BaseController {

    private final AggregateQueryService service;

    @Operation(summary = "Get Aggregate")
    @GetMapping("/{aggregateId}")
    public ResponseEntity<ApiResponse<AggregateDetailsResponse>> getAggregate(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("Aggregate loaded successfully.", service.getAggregate(aggregateId)));

    }

    @Operation(summary = "List Aggregates")
    @GetMapping("/microservice/{microserviceId}")
    public ResponseEntity<ApiResponse<List<AggregateDetailsResponse>>> listAggregates(@PathVariable("microserviceId") String microserviceId) {

        return ResponseEntity.ok(ApiResponse.success("Aggregates loaded successfully.", service.getAggregates(microserviceId)));

    }

}