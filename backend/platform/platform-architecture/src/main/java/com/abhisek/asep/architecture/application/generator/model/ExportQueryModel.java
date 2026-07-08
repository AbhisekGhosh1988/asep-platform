package com.abhisek.asep.architecture.application.generator.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExportQueryModel {

    private String id;

    private String name;

    private String description;

}