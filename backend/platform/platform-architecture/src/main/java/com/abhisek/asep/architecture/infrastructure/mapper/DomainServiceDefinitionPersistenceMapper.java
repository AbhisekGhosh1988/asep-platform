package com.abhisek.asep.architecture.infrastructure.mapper;

import com.abhisek.asep.architecture.domain.model.DomainServiceDefinition;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.DomainServiceDefinitionEntity;

public interface DomainServiceDefinitionPersistenceMapper {

    DomainServiceDefinitionEntity toEntity(
            DomainServiceDefinition domainService);

    DomainServiceDefinition toDomain(
            DomainServiceDefinitionEntity entity);

}