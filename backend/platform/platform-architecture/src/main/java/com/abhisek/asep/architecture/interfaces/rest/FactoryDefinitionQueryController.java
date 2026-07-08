package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.factory.query.dto.FactoryDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.factory.query.service.FactoryDefinitionQueryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/design/factories")
@RequiredArgsConstructor
@Tag(name = "Factory Query")
public class FactoryDefinitionQueryController extends BaseController {

    private final FactoryDefinitionQueryService service;

    @Operation(summary = "Get Factory")
    @GetMapping("/{factoryId}")
    public ResponseEntity<ApiResponse<FactoryDefinitionDetailsResponse>> getFactory(@PathVariable("factoryId") String factoryId) {

        return ResponseEntity.ok(ApiResponse.success("Factory loaded successfully.", service.getFactory(factoryId)));

    }

    @Operation(summary = "List Factories")
    @GetMapping("/aggregate/{aggregateId}")
    public ResponseEntity<ApiResponse<List<FactoryDefinitionDetailsResponse>>> getFactories(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("Factories loaded successfully.", service.getFactories(aggregateId)));

    }

}