package com.abhisek.asep.core.application.usecase;

/**
 * Command use case without request and response.
 */
public interface VoidNoRequestCommandUseCase extends BaseUseCase {

    void execute();

}