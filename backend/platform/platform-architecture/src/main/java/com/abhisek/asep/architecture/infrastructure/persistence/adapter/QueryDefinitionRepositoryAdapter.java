package com.abhisek.asep.architecture.infrastructure.persistence.adapter;

import com.abhisek.asep.architecture.domain.model.QueryDefinition;
import com.abhisek.asep.architecture.domain.repository.QueryDefinitionRepository;
import com.abhisek.asep.architecture.infrastructure.mapper.QueryDefinitionPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.repository.JpaQueryDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class QueryDefinitionRepositoryAdapter
        implements QueryDefinitionRepository {

    private final JpaQueryDefinitionRepository repository;

    private final QueryDefinitionPersistenceMapper mapper;

    @Override
    public QueryDefinition save(
            QueryDefinition queryDefinition) {

        return mapper.toDomain(
                repository.save(
                        mapper.toEntity(queryDefinition)));

    }

    @Override
    public Optional<QueryDefinition> findById(
            String id) {

        return repository.findById(id)
                .map(mapper::toDomain);

    }

    @Override
    public List<QueryDefinition> findByAggregateId(
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