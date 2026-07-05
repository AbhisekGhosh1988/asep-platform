package com.abhisek.asep.core.application.usecase;

/**
 * Command use case returning no value.
 */
public interface VoidCommandUseCase<REQUEST> extends BaseUseCase {

    void execute(REQUEST request);

}