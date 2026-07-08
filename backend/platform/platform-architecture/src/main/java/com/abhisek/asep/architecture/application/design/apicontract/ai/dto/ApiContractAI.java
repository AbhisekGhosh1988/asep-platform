package com.abhisek.asep.architecture.application.design.apicontract.ai.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiContractAI {

    /**
     * Operation name.
     */
    private String name;

    /**
     * HTTP Method.
     */
    private String method;

    /**
     * REST Path.
     */
    private String path;

    /**
     * Business description.
     */
    private String description;

}