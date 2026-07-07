package com.abhisek.asep.architecture.application.design.domainservice.query.mapper;

import com.abhisek.asep.architecture.application.design.domainservice.query.dto.DomainServiceDefinitionDetailsResponse;
import com.abhisek.asep.architecture.domain.model.DomainServiceDefinition;

public interface DomainServiceDefinitionQueryMapper {

    DomainServiceDefinitionDetailsResponse toResponse(
            DomainServiceDefinition domainService);

}