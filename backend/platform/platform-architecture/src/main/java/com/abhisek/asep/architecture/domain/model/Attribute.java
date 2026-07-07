package com.abhisek.asep.architecture.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attribute {

    /**
     * Unique identifier.
     */
    private String id;

    /**
     * Parent Entity.
     */
    private String entityId;

    /**
     * Attribute name.
     */
    private String name;

    /**
     * Java data type.
     *
     * Examples:
     * String
     * Integer
     * Long
     * UUID
     * LocalDate
     */
    private String dataType;

    /**
     * Required field.
     */
    private Boolean required;

    /**
     * Nullable in database.
     */
    private Boolean nullable;

    /**
     * Unique constraint.
     */
    private Boolean unique;

    /**
     * Collection type.
     */
    private Boolean collection;

    /**
     * Default value.
     */
    private String defaultValue;

    /**
     * Maximum length.
     */
    private Integer length;

    /**
     * Numeric precision.
     */
    private Integer precision;

    /**
     * Numeric scale.
     */
    private Integer scale;

    /**
     * Description.
     */
    private String description;
    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

}