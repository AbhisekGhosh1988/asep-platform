package com.abhisek.asep.requirements.application.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequirementAIAnalysisResponse {

    private Double completenessScore;

    private Double ambiguityScore;

    private Double qualityScore;

    private String analysis;

}