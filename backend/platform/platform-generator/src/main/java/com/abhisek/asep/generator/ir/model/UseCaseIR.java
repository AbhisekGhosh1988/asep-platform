package com.abhisek.asep.generator.ir.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UseCaseIR
        extends BaseIRNode {

    /**
     * Command / Query.
     */
    private UseCaseType type;

    /**
     * Request DTO.
     */
    private String requestDto;

    /**
     * Response DTO.
     */
    private String responseDto;

    /*
     * Compiler-resolved dependencies.
     */

    private RepositoryIR repository;

    private MapperIR mapper;

    private DomainServiceIR domainService;

}