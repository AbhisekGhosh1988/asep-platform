package com.abhisek.asep.generator.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectModel {

    private String id;

    private String name;

    private String description;

    private String groupId;

    private String artifactId;

    private String version;

    private String packageName;

}