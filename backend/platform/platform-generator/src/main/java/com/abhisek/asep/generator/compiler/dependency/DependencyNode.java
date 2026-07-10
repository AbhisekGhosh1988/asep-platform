package com.abhisek.asep.generator.compiler.dependency;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DependencyNode {

    /**
     * Compiler object name.
     */
    private final String name;

}