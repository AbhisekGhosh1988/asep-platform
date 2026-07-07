package com.abhisek.asep.architecture.application.design.domainservice.imports.mapper;

import com.abhisek.asep.architecture.application.design.domainservice.imports.dto.request.DomainServiceDefinitionImportRequest;
import com.abhisek.asep.architecture.domain.model.DomainServiceDefinition;

public interface DomainServiceDefinitionImportMapper {

    DomainServiceDefinition toDomainService(
            DomainServiceDefinitionImportRequest request);

}