package com.abhisek.asep.requirements.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequirementVersionComparisonResponse {

    private Integer sourceVersion;

    private Integer targetVersion;

    private List<FieldDifferenceResponse> differences;

}