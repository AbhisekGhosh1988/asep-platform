package com.abhisek.asep.core.application.service;

/**
 * Generic CRUD command contract.
 *
 * @param <ID> Entity identifier
 * @param <CREATE> Create request
 * @param <UPDATE> Update request
 * @param <RESPONSE> Response DTO
 */
public interface CrudCommandService<ID, CREATE, UPDATE, RESPONSE>
        extends BaseService {

    RESPONSE create(CREATE request);

    RESPONSE update(ID id, UPDATE request);

    void delete(ID id);

}