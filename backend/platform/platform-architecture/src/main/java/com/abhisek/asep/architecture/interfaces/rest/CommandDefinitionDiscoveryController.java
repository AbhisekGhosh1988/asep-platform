package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.command.ai.dto.CommandDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.command.service.CommandDefinitionDiscoveryService;
import com.abhisek.asep.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/design/commands")
@RequiredArgsConstructor
@Tag(name = "Command Discovery")
public class CommandDefinitionDiscoveryController {

    private final CommandDefinitionDiscoveryService service;

    @Operation(summary = "Discover Commands")
    @PostMapping("/discover/{aggregateId}")
    public ResponseEntity<ApiResponse<CommandDefinitionDiscoveryResponse>>
    discover(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("Commands discovered successfully.",
                service.discover(aggregateId)));

    }

}