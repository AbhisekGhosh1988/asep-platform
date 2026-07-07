package com.abhisek.asep.architecture.infrastructure.persistence.adapter;

import com.abhisek.asep.architecture.domain.model.DomainEventDefinition;
import com.abhisek.asep.architecture.domain.repository.DomainEventDefinitionRepository;
import com.abhisek.asep.architecture.infrastructure.mapper.DomainEventDefinitionPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.repository.JpaDomainEventDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DomainEventDefinitionRepositoryAdapter
        implements DomainEventDefinitionRepository {

    private final JpaDomainEventDefinitionRepository repository;

    private final DomainEventDefinitionPersistenceMapper mapper;

    @Override
    public DomainEventDefinition save(
            DomainEventDefinition domainEvent) {

        return mapper.toDomain(
                repository.save(
                        mapper.toEntity(domainEvent)));

    }

    @Override
    public Optional<DomainEventDefinition> findById(
            String id) {

        return repository.findById(id)
                .map(mapper::toDomain);

    }

    @Override
    public List<DomainEventDefinition> findByAggregateId(
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