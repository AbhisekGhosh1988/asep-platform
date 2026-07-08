package com.abhisek.asep.architecture.infrastructure.persistence.adapter;

import com.abhisek.asep.architecture.domain.model.FactoryDefinition;
import com.abhisek.asep.architecture.domain.repository.FactoryDefinitionRepository;
import com.abhisek.asep.architecture.infrastructure.mapper.FactoryDefinitionPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.repository.JpaFactoryDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FactoryDefinitionRepositoryAdapter
        implements FactoryDefinitionRepository {

    private final JpaFactoryDefinitionRepository repository;

    private final FactoryDefinitionPersistenceMapper mapper;

    @Override
    public FactoryDefinition save(
            FactoryDefinition factoryDefinition) {

        return mapper.toDomain(
                repository.save(
                        mapper.toEntity(factoryDefinition)));

    }

    @Override
    public Optional<FactoryDefinition> findById(
            String id) {

        return repository.findById(id)
                .map(mapper::toDomain);

    }

    @Override
    public List<FactoryDefinition> findByAggregateId(
            String aggregateId) {

        return repository.findByAggregateId(aggregateId)
                .stream()
                .map(mapper::toDomain)
                .toList();

    }

    @Override
    public boolean existsByAggregateIdAndName(
            String aggregateId,
            String name) {

        return repository.existsByAggregateIdAndName(
                aggregateId,
                name);

    }

}