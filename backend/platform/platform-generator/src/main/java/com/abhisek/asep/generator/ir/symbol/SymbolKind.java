package com.abhisek.asep.generator.ir.symbol;

/**
 * Represents the type of symbol registered in the compiler.
 */
public enum SymbolKind {

    PROJECT,

    AGGREGATE,

    ENTITY,

    VALUE_OBJECT,

    REPOSITORY,

    DOMAIN_SERVICE,

    DOMAIN_EVENT,

    API_CONTRACT,

    COMMAND,

    QUERY,

    FACTORY,

    SPECIFICATION,

    POLICY,

    DTO,

    MAPPER,

    USE_CASE

}