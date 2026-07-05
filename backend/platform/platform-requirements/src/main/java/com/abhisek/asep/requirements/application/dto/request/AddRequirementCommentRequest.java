package com.abhisek.asep.requirements.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRequirementCommentRequest {

    @NotBlank(message = "Comment is required")
    private String comment;

    @NotBlank(message = "Commented By is required")
    private String commentedBy;

}