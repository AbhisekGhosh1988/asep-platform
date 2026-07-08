package com.abhisek.asep.generator.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WorkspaceModel {

    /**
     * Root output directory.
     */
    private String outputDirectory;

    /**
     * Temporary working directory.
     */
    private String tempDirectory;

    /**
     * Generated source directory.
     */
    private String sourceDirectory;

    /**
     * Resource directory.
     */
    private String resourceDirectory;

}