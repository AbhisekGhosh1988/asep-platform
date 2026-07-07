package com.abhisek.asep.architecture.application.design.query.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AggregateDetailsResponse {

    private String id;

    private String microserviceId;

    private String name;

    private String description;

}