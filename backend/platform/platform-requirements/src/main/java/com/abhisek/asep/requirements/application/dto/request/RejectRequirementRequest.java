package com.abhisek.asep.requirements.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RejectRequirementRequest {

    @NotBlank
    private String reason;

}