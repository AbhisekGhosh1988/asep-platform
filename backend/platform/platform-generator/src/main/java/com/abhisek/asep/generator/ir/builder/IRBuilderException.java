package com.abhisek.asep.generator.ir.builder;

/**
 * Exception thrown while building IR.
 */
public class IRBuilderException
        extends RuntimeException {

    public IRBuilderException(String message) {
        super(message);
    }

    public IRBuilderException(
            String message,
            Throwable cause) {
        super(message, cause);
    }

}