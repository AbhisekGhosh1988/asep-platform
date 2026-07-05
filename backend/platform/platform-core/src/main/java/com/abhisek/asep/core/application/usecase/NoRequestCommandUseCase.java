package com.abhisek.asep.core.application.usecase;

/**
 * Command use case without request object.
 */
public interface NoRequestCommandUseCase<RESPONSE> extends BaseUseCase {

    RESPONSE execute();

}