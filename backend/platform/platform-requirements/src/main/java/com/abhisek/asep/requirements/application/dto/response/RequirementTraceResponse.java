package com.abhisek.asep.requirements.application.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequirementTraceResponse {

    private String targetType;

    private String targetId;

}