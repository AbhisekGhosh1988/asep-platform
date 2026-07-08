package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.specification.query.dto.SpecificationDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.specification.query.service.SpecificationDefinitionQueryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/design/specifications")
@RequiredArgsConstructor
@Tag(name = "Specification Query")
public class SpecificationDefinitionQueryController extends BaseController {

    private final SpecificationDefinitionQueryService service;

    @Operation(summary = "Get Specification")
    @GetMapping("/{specificationId}")
    public ResponseEntity<ApiResponse<SpecificationDefinitionDetailsResponse>> getSpecification(@PathVariable("specificationId") String specificationId) {

        return ResponseEntity.ok(ApiResponse.success("Specification loaded successfully.", service.getSpecification(specificationId)));

    }

    @Operation(summary = "List Specifications")
    @GetMapping("/aggregate/{aggregateId}")
    public ResponseEntity<ApiResponse<List<SpecificationDefinitionDetailsResponse>>> getSpecifications(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("Specifications loaded successfully.", service.getSpecifications(aggregateId)));

    }

}