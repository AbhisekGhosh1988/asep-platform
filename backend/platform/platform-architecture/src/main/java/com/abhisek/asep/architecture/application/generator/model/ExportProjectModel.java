package com.abhisek.asep.architecture.application.generator.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExportProjectModel {

    private String projectId;

    private String projectName;

    private String description;

    @Builder.Default
    private List<ExportAggregateModel> aggregates =
            new ArrayList<>();

}