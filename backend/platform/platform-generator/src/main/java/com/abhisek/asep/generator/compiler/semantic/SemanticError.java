package com.abhisek.asep.generator.compiler.semantic;

import lombok.Builder;
import lombok.Getter;

/**
 * Represents a semantic validation error.
 */
@Getter
@Builder
public class SemanticError {

    /**
     * Error code.
     */
    private final String code;

    /**
     * Human readable message.
     */
    private final String message;

    /**
     * Affected compiler object.
     */
    private final String target;

}