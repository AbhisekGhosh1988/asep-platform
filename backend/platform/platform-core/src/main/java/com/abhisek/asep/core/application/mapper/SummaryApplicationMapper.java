package com.abhisek.asep.core.application.mapper;

/**
 * Mapper for summary DTOs.
 *
 * @param <DOMAIN> Domain model
 * @param <SUMMARY> Summary DTO
 */
public interface SummaryApplicationMapper<
        DOMAIN,
        SUMMARY> {

    SUMMARY toSummary(DOMAIN domain);

}