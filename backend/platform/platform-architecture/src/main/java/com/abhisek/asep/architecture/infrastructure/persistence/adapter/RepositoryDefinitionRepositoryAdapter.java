package com.abhisek.asep.architecture.infrastructure.persistence.adapter;

import com.abhisek.asep.architecture.domain.model.RepositoryDefinition;
import com.abhisek.asep.architecture.domain.repository.RepositoryDefinitionRepository;
import com.abhisek.asep.architecture.infrastructure.mapper.RepositoryDefinitionPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.repository.JpaRepositoryDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RepositoryDefinitionRepositoryAdapter implements RepositoryDefinitionRepository {

    private final JpaRepositoryDefinitionRepository repository;

    private final RepositoryDefinitionPersistenceMapper mapper;

    @Override
    public RepositoryDefinition save(RepositoryDefinition repositoryDefinition) {

        return mapper.toDomain(repository.save(mapper.toEntity(repositoryDefinition)));

    }

    @Override
    public Optional<RepositoryDefinition> findById(String id) {

        return repository.findById(id).map(mapper::toDomain);

    }

    @Override
    public List<RepositoryDefinition> findByAggregateId(String aggregateId) {

        return repository.findByAggregateId(aggregateId).stream().map(mapper::toDomain).toList();

    }

    @Override
    public boolean existsByAggregateIdAndName(String aggregateId, String name) {

        return repository.existsByAggregateIdAndName(aggregateId, name);

    }

}