package com.abhisek.asep.architecture.application.design.valueobject.query.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValueObjectDetailsResponse {

    private String id;

    private String aggregateId;

    private String name;

    private String description;

    private Boolean immutable;

}