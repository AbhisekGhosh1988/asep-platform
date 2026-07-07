package com.abhisek.asep.architecture.application.design.repository.query.mapper.impl;

import com.abhisek.asep.architecture.application.design.repository.query.dto.RepositoryDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.repository.query.mapper.RepositoryDefinitionQueryMapper;
import com.abhisek.asep.architecture.domain.model.RepositoryDefinition;
import org.springframework.stereotype.Component;

@Component
public class RepositoryDefinitionQueryMapperImpl implements RepositoryDefinitionQueryMapper {

    @Override
    public RepositoryDefinitionDetailsResponse toResponse(RepositoryDefinition repository) {

        if (repository == null) {
            return null;
        }

        return RepositoryDefinitionDetailsResponse.builder().id(repository.getId()).aggregateId(repository.getAggregateId()).name(repository.getName()).description(repository.getDescription()).build();

    }

}