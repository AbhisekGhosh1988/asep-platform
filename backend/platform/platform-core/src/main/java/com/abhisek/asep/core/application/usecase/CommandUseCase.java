package com.abhisek.asep.core.application.usecase;

/**
 * Base interface for command use cases.
 *
 * @param <REQUEST> Request DTO
 * @param <RESPONSE> Response DTO
 */
public interface CommandUseCase<REQUEST, RESPONSE> extends BaseUseCase {

    RESPONSE execute(REQUEST request);

}