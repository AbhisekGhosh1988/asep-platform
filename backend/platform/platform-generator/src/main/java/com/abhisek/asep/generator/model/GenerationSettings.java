package com.abhisek.asep.generator.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GenerationSettings {

    private String language;

    private String framework;

    private String frameworkVersion;

    private String javaVersion;

    private String buildTool;

    private String database;

    private String messaging;

    private String security;

    private boolean generateTests;

    private boolean generateDocumentation;

}