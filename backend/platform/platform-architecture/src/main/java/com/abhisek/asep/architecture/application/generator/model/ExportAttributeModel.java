package com.abhisek.asep.architecture.application.generator.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExportAttributeModel {

    private String id;

    private String name;

    private String description;

    private String dataType;

    private boolean identifier;

    private boolean nullable;

    private boolean unique;

    private boolean collection;

    private String defaultValue;

}