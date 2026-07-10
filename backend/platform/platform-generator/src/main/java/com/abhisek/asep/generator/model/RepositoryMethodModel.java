package com.abhisek.asep.generator.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryMethodModel
        extends BaseArtifactModel {

    private String returnType;

    @Builder.Default
    private List<ParameterModel> parameters =
            new ArrayList<>();

}