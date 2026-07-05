package com.abhisek.asep.requirements.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import com.abhisek.asep.requirements.application.ai.RequirementAIAnalysisService;
import com.abhisek.asep.requirements.domain.model.RequirementAnalysis;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/requirements")
@RequiredArgsConstructor
@Tag(name = "Requirement AI")
public class RequirementAIController extends BaseController {

    private final RequirementAIAnalysisService service;

    @Operation(summary = "Analyze Requirement using AI")
    @PostMapping("/{requirementId}/analyze")
    public ResponseEntity<ApiResponse<RequirementAnalysis>> analyze(@PathVariable String requirementId) {

        return ok("Requirement analyzed successfully", service.analyze(requirementId));

    }

}