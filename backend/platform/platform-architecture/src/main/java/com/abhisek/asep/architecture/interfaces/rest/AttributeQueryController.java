package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.attribute.query.dto.AttributeDetailsResponse;
import com.abhisek.asep.architecture.application.design.attribute.query.service.AttributeQueryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/design/attributes")
@RequiredArgsConstructor
@Tag(name = "Attribute Query")
public class AttributeQueryController extends BaseController {

    private final AttributeQueryService service;

    @Operation(summary = "Get Attribute")
    @GetMapping("/{attributeId}")
    public ResponseEntity<ApiResponse<AttributeDetailsResponse>> getAttribute(@PathVariable("attributeId") String attributeId) {

        return ResponseEntity.ok(ApiResponse.success("Attribute loaded successfully.", service.getAttribute(attributeId)));

    }

    @Operation(summary = "List Attributes")
    @GetMapping("/entity/{entityId}")
    public ResponseEntity<ApiResponse<List<AttributeDetailsResponse>>> getAttributes(@PathVariable("entityId") String entityId) {

        return ResponseEntity.ok(ApiResponse.success("Attributes loaded successfully.", service.getAttributes(entityId)));

    }

}