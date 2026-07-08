package com.abhisek.asep.architecture.infrastructure.persistence.adapter;

import com.abhisek.asep.architecture.domain.model.SpecificationDefinition;
import com.abhisek.asep.architecture.domain.repository.SpecificationDefinitionRepository;
import com.abhisek.asep.architecture.infrastructure.mapper.SpecificationDefinitionPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.repository.JpaSpecificationDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SpecificationDefinitionRepositoryAdapter
        implements SpecificationDefinitionRepository {

    private final JpaSpecificationDefinitionRepository repository;

    private final SpecificationDefinitionPersistenceMapper mapper;

    @Override
    public SpecificationDefinition save(
            SpecificationDefinition specification) {

        return mapper.toDomain(
                repository.save(
                        mapper.toEntity(specification)));

    }

    @Override
    public Optional<SpecificationDefinition> findById(
            String id) {

        return repository.findById(id)
                .map(mapper::toDomain);

    }

    @Override
    public List<SpecificationDefinition> findByAggregateId(
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