package com.abhisek.asep.architecture.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Endpoint {

    /**
     * Unique identifier.
     */
    private String id;

    /**
     * Parent API.
     */
    private String apiContractId;

    /**
     * Endpoint name.
     */
    private String name;

    /**
     * HTTP Method.
     *
     * GET
     * POST
     * PUT
     * DELETE
     * PATCH
     */
    private String httpMethod;

    /**
     * Relative path.
     */
    private String path;

    /**
     * Summary.
     */
    private String summary;

    /**
     * Secured endpoint.
     */
    private Boolean secured;

}