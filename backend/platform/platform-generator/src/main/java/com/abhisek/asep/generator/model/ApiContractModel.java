package com.abhisek.asep.generator.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ApiContractModel
        extends BaseArtifactModel {

    private String method;

    private String path;

}