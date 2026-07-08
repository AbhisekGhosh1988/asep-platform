package com.abhisek.asep.architecture.infrastructure.persistence.adapter;

import com.abhisek.asep.architecture.domain.model.PolicyDefinition;
import com.abhisek.asep.architecture.domain.repository.PolicyDefinitionRepository;
import com.abhisek.asep.architecture.infrastructure.mapper.PolicyDefinitionPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.repository.JpaPolicyDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PolicyDefinitionRepositoryAdapter
        implements PolicyDefinitionRepository {

    private final JpaPolicyDefinitionRepository repository;

    private final PolicyDefinitionPersistenceMapper mapper;

    @Override
    public PolicyDefinition save(
            PolicyDefinition policy) {

        return mapper.toDomain(
                repository.save(
                        mapper.toEntity(policy)));

    }

    @Override
    public Optional<PolicyDefinition> findById(
            String id) {

        return repository.findById(id)
                .map(mapper::toDomain);

    }

    @Override
    public List<PolicyDefinition> findByAggregateId(
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