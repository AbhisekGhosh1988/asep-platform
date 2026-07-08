package com.abhisek.asep.generator.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttributeModel {

    private String id;

    private String name;

    private String dataType;

    private boolean nullable;

    private boolean identifier;

}