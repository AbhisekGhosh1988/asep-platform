package com.abhisek.asep.core.application.mapper;

/**
 * Generic mapper contract.
 *
 * @param <DOMAIN> Domain model
 * @param <REQUEST> Request DTO
 * @param <RESPONSE> Response DTO
 */
public interface ApplicationMapper<
        DOMAIN,
        REQUEST,
        RESPONSE> {

    DOMAIN toDomain(REQUEST request);

    RESPONSE toResponse(DOMAIN domain);

}