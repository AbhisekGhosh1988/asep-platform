package com.abhisek.asep.core.application.service;

/**
 * Base interface for command services.
 *
 * @param <REQUEST> Request DTO
 * @param <RESPONSE> Response DTO
 */
public interface BaseCommandService<REQUEST, RESPONSE>
        extends BaseService {

    RESPONSE execute(REQUEST request);

}