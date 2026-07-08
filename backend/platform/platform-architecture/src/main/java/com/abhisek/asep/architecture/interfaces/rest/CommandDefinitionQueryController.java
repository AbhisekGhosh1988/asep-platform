package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.command.query.dto.CommandDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.command.query.service.CommandDefinitionQueryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/design/commands")
@RequiredArgsConstructor
@Tag(name = "Command Query")
public class CommandDefinitionQueryController extends BaseController {

    private final CommandDefinitionQueryService service;

    @Operation(summary = "Get Command")
    @GetMapping("/{commandId}")
    public ResponseEntity<ApiResponse<CommandDefinitionDetailsResponse>>
    getCommand(@PathVariable("commandId") String commandId) {

        return ResponseEntity.ok(ApiResponse.success("Command loaded successfully.",
                service.getCommand(commandId)));

    }

    @Operation(summary = "List Commands")
    @GetMapping("/aggregate/{aggregateId}")
    public ResponseEntity<ApiResponse<List<CommandDefinitionDetailsResponse>>>
    getCommands(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("Commands loaded successfully.",
                service.getCommands(aggregateId)));

    }

}