package com.abhisek.asep.generator.backend.template;

import lombok.Builder;
import lombok.Getter;

/**
 * Represents a code generation template.
 */
@Getter
@Builder
public class Template {

    /**
     * Template identifier.
     */
    private final String name;

    /**
     * Template content.
     */
    private final String content;

}