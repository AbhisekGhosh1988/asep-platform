package com.abhisek.asep.core.application.service;

/**
 * Base interface for query services.
 *
 * @param <REQUEST> Request DTO
 * @param <RESPONSE> Response DTO
 */
public interface BaseQueryService<REQUEST, RESPONSE>
        extends BaseService {

    RESPONSE execute(REQUEST request);

}
