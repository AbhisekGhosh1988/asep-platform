package com.abhisek.asep.architecture.application.design.domainservice.imports.mapper.impl;

import com.abhisek.asep.architecture.application.design.domainservice.imports.dto.request.DomainServiceDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.domainservice.imports.mapper.DomainServiceDefinitionImportMapper;
import com.abhisek.asep.architecture.domain.model.DomainServiceDefinition;
import org.springframework.stereotype.Component;

@Component
public class DomainServiceDefinitionImportMapperImpl implements DomainServiceDefinitionImportMapper {

    @Override
    public DomainServiceDefinition toDomainService(DomainServiceDefinitionImportRequest request) {

        return DomainServiceDefinition.builder().aggregateId(request.getAggregateId()).name(request.getName()).description(request.getDescription()).build();

    }

}