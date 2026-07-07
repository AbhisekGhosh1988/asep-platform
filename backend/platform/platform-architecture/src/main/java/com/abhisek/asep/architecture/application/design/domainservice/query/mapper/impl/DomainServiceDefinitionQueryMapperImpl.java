package com.abhisek.asep.architecture.application.design.domainservice.query.mapper.impl;

import com.abhisek.asep.architecture.application.design.domainservice.query.dto.DomainServiceDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.domainservice.query.mapper.DomainServiceDefinitionQueryMapper;
import com.abhisek.asep.architecture.domain.model.DomainServiceDefinition;
import org.springframework.stereotype.Component;

@Component
public class DomainServiceDefinitionQueryMapperImpl
        implements DomainServiceDefinitionQueryMapper {

    @Override
    public DomainServiceDefinitionDetailsResponse toResponse(
            DomainServiceDefinition domainService) {

        if (domainService == null) {
            return null;
        }

        return DomainServiceDefinitionDetailsResponse.builder()
                .id(domainService.getId())
                .aggregateId(domainService.getAggregateId())
                .name(domainService.getName())
                .description(domainService.getDescription())
                .build();

    }

}