package com.abhisek.asep.requirements.application.dto.response;

import com.abhisek.asep.requirements.domain.enums.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequirementSummaryResponse {

    private String id;

    private String title;

    private RequirementType type;

    private RequirementStatus status;

    private Priority priority;

}