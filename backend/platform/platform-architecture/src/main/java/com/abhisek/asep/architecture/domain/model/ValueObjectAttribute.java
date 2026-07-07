package com.abhisek.asep.architecture.domain.model;

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
public class ValueObjectAttribute {

    /**
     * Unique identifier.
     */
    private String id;

    /**
     * Parent Value Object.
     */
    private String valueObjectId;

    /**
     * Attribute name.
     */
    private String name;

    /**
     * Java data type.
     */
    private String dataType;

    /**
     * Required.
     */
    private Boolean required;

    /**
     * Nullable.
     */
    private Boolean nullable;

    /**
     * Default value.
     */
    private String defaultValue;

    /**
     * Length.
     */
    private Integer length;

    /**
     * Description.
     */
    private String description;

}