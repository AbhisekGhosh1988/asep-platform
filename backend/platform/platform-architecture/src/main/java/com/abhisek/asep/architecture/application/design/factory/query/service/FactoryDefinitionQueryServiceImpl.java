package com.abhisek.asep.architecture.application.design.factory.query.service;

import com.abhisek.asep.architecture.application.design.factory.query.dto.FactoryDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.factory.query.mapper.FactoryDefinitionQueryMapper;
import com.abhisek.asep.architecture.domain.repository.FactoryDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FactoryDefinitionQueryServiceImpl
        implements FactoryDefinitionQueryService {

    private final FactoryDefinitionRepository repository;

    private final FactoryDefinitionQueryMapper mapper;

    @Override
    public FactoryDefinitionDetailsResponse getFactory(
            String factoryId) {

        return repository.findById(factoryId)
                .map(mapper::toResponse)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Factory Definition not found : "
                                        + factoryId));

    }

    @Override
    public List<FactoryDefinitionDetailsResponse> getFactories(
            String aggregateId) {

        return repository.findByAggregateId(aggregateId)
                .stream()
                .map(mapper::toResponse)
                .toList();

    }

}