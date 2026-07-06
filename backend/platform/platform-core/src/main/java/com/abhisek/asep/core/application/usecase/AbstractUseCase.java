package com.abhisek.asep.core.application.usecase;

import java.time.Instant;
import java.util.UUID;

/**
 * Base class for all application use cases.
 */
public abstract class AbstractUseCase {

    /**
     * Generates a new UUID.
     */
    protected String newId() {

        return UUID.randomUUID().toString();

    }

    /**
     * Returns current UTC timestamp.
     */
    protected Instant now() {

        return Instant.now();

    }

    /**
     * Returns current authenticated user.
     *
     * TODO Replace with SecurityContext after Identity module is completed.
     */
    protected String currentUser() {

        return "SYSTEM";

    }

}