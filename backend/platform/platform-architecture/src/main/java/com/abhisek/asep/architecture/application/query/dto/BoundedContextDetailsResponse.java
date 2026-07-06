package com.abhisek.asep.architecture.application.query.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoundedContextDetailsResponse {

    private String id;

    private String name;

    private String description;

    private String responsibility;

    @Builder.Default
    private List<MicroserviceDetailsResponse> microservices = new ArrayList<>();

}