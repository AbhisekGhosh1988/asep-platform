package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.valueobject.query.dto.ValueObjectDetailsResponse;
import com.abhisek.asep.architecture.application.design.valueobject.query.service.ValueObjectQueryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/design/value-objects")
@RequiredArgsConstructor
@Tag(name = "Value Object Query")
public class ValueObjectQueryController extends BaseController {

    private final ValueObjectQueryService service;

    @Operation(summary = "Get Value Object")
    @GetMapping("/{valueObjectId}")
    public ResponseEntity<ApiResponse<ValueObjectDetailsResponse>> getValueObject(@PathVariable("valueObjectId") String valueObjectId) {

        return ResponseEntity.ok(ApiResponse.success("Value Object loaded successfully.", service.getValueObject(valueObjectId)));

    }

    @Operation(summary = "List Value Objects")
    @GetMapping("/aggregate/{aggregateId}")
    public ResponseEntity<ApiResponse<List<ValueObjectDetailsResponse>>> getValueObjects(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("Value Objects loaded successfully.", service.getValueObjects(aggregateId)));

    }

}