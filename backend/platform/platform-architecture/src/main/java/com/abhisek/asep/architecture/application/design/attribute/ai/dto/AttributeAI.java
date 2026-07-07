package com.abhisek.asep.architecture.application.design.attribute.ai.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttributeAI {

    private String name;

    private String dataType;

    private Boolean required;

    private Boolean nullable;

    private Boolean unique;

    private String description;

}