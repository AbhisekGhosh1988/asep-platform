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
public class PolicyModel
        extends BaseArtifactModel {

    /**
     * Policy operations.
     */
    @Builder.Default
    private List<ServiceOperationModel> operations =
            new ArrayList<>();

}