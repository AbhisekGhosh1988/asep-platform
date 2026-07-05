package com.abhisek.asep.core.application.facade;

import java.util.List;

/**
 * Generic CRUD facade.
 *
 * @param <ID> Identifier
 * @param <CREATE> Create request
 * @param <UPDATE> Update request
 * @param <RESPONSE> Response DTO
 * @param <SUMMARY> Summary DTO
 */
public interface CrudFacade<
        ID,
        CREATE,
        UPDATE,
        RESPONSE,
        SUMMARY> extends ApplicationFacade {

    RESPONSE create(CREATE request);

    RESPONSE update(ID id, UPDATE request);

    void delete(ID id);

    RESPONSE get(ID id);

    List<SUMMARY> list();

}