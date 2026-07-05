package com.abhisek.asep.core.application.usecase;

/**
 * Base interface for query use cases.
 *
 * @param <REQUEST> Request DTO
 * @param <RESPONSE> Response DTO
 */
public interface QueryUseCase<REQUEST, RESPONSE> extends BaseUseCase {

    RESPONSE execute(REQUEST request);

}