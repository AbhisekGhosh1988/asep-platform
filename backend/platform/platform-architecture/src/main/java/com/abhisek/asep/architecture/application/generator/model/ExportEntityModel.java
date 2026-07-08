package com.abhisek.asep.architecture.application.generator.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExportEntityModel {

    private String id;

    private String name;

    private String description;

    @Builder.Default
    private List<ExportAttributeModel> attributes =
            new ArrayList<>();

    @Builder.Default
    private List<ExportRelationshipModel> relationships =
            new ArrayList<>();

}