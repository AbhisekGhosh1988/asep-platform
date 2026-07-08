package com.abhisek.asep.generator.ir.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectIR
        extends BaseIRNode {

    /**
     * Group Id.
     */
    private String groupId;

    /**
     * Artifact Id.
     */
    private String artifactId;

    /**
     * Version.
     */
    private String version;

    /**
     * Base package.
     */
    private String basePackage;

    /**
     * Aggregates.
     */
    @Builder.Default
    private List<AggregateIR> aggregates =
            new ArrayList<>();

}