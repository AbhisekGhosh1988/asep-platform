package com.abhisek.asep.generator.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseArtifactModel {

    protected String id;

    protected String name;

    protected String description;

}