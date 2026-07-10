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
public class FactoryModel extends BaseArtifactModel {

    /**
     * Factory methods.
     */
    @Builder.Default
    private List<ServiceOperationModel> methods =
            new ArrayList<>();

}