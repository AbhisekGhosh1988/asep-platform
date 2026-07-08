package com.abhisek.asep.architecture.application.design.policy.query.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyDefinitionDetailsResponse {

    private String id;
    private String aggregateId;
    private String name;
    private String description;

}