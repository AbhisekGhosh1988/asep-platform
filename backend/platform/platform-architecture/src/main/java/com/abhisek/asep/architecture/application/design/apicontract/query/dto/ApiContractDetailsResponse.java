package com.abhisek.asep.architecture.application.design.apicontract.query.dto;

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
public class ApiContractDetailsResponse {

    private String id;

    private String aggregateId;

    private String name;

    private String method;

    private String path;

    private String description;

}