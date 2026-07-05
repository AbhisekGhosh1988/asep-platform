package com.abhisek.asep.core.application.service;

import java.util.List;

/**
 * Generic CRUD query contract.
 *
 * @param <ID> Entity identifier
 * @param <RESPONSE> Response DTO
 * @param <SUMMARY> Summary DTO
 */
public interface CrudQueryService<ID, RESPONSE, SUMMARY>
        extends BaseService {

    RESPONSE getById(ID id);

    List<SUMMARY> list();

}