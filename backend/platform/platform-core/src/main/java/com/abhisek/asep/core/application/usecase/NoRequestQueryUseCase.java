package com.abhisek.asep.core.application.usecase;

/**
 * Query use case without request object.
 */
public interface NoRequestQueryUseCase<RESPONSE> extends BaseUseCase {

    RESPONSE execute();

}