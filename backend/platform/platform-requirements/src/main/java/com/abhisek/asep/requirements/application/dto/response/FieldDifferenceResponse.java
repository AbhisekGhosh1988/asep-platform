package com.abhisek.asep.requirements.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FieldDifferenceResponse {

    private String field;

    private Object oldValue;

    private Object newValue;

}