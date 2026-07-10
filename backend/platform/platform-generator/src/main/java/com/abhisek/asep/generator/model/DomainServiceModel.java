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
public class DomainServiceModel
        extends BaseArtifactModel {

    /**
     * Service operations.
     */
    @Builder.Default
    private List<ServiceOperationModel> operations =
            new ArrayList<>();

}