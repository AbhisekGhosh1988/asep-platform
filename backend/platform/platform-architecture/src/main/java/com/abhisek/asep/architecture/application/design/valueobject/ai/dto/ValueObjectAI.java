package com.abhisek.asep.architecture.application.design.valueobject.ai.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValueObjectAI {

    private String name;

    private String description;

    private Boolean immutable;

}