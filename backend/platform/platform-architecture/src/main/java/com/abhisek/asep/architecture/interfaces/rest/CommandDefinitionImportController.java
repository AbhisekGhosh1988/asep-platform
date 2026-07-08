package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.command.imports.dto.request.CommandDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.command.imports.dto.response.CommandDefinitionImportResponse;
import com.abhisek.asep.architecture.application.design.command.imports.service.CommandDefinitionImportService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/design/commands")
@RequiredArgsConstructor
@Tag(name = "Command Import")
public class CommandDefinitionImportController extends BaseController {

    private final CommandDefinitionImportService service;

    @Operation(summary = "Import Command")
    @PostMapping("/import")
    public ResponseEntity<ApiResponse<CommandDefinitionImportResponse>>
    importCommand(@Valid @RequestBody CommandDefinitionImportRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).
                body(ApiResponse.success("Command imported successfully.",
                        service.importCommand(request)));

    }

}