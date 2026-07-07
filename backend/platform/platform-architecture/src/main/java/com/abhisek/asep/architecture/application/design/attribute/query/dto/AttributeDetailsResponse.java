package com.abhisek.asep.architecture.application.design.attribute.query.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttributeDetailsResponse {

    private String id;

    private String entityId;

    private String name;

    private String dataType;

    private Boolean required;

    private Boolean nullable;

    private Boolean unique;

    private Boolean collection;

    private String defaultValue;

    private Integer length;

    private Integer precision;

    private Integer scale;

    private String description;

}