package com.abhisek.asep.common.enums;

public enum ErrorCode {

    // Common
    INTERNAL_SERVER_ERROR("ASEP-0001", "Internal server error"),
    INVALID_REQUEST("ASEP-0002", "Invalid request"),
    VALIDATION_FAILED("ASEP-0003", "Validation failed"),
    RESOURCE_NOT_FOUND("ASEP-0004", "Resource not found"),
    UNAUTHORIZED("ASEP-0005", "Unauthorized"),
    FORBIDDEN("ASEP-0006", "Forbidden"),
    CONFLICT("ASEP-0007", "Conflict"),
    BAD_REQUEST("ASEP-0008", "Bad request"),

    // Authentication
    INVALID_CREDENTIALS("AUTH-0001", "Invalid credentials"),
    ACCOUNT_LOCKED("AUTH-0002", "Account locked"),
    ACCOUNT_DISABLED("AUTH-0003", "Account disabled"),
    TOKEN_EXPIRED("AUTH-0004", "Token expired"),
    TOKEN_INVALID("AUTH-0005", "Invalid token"),

    // AI
    AI_PROVIDER_ERROR("AI-0001", "AI provider error"),
    AI_TIMEOUT("AI-0002", "AI request timeout"),
    AI_RESPONSE_INVALID("AI-0003", "Invalid AI response"),

    // Generator
    GENERATION_FAILED("GEN-0001", "Generation failed"),
    TEMPLATE_NOT_FOUND("GEN-0002", "Template not found"),
    INVALID_SPECIFICATION("GEN-0003", "Invalid specification");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}