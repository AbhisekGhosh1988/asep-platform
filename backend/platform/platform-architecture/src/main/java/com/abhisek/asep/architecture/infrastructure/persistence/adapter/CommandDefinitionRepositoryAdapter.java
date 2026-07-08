package com.abhisek.asep.architecture.infrastructure.persistence.adapter;

import com.abhisek.asep.architecture.domain.model.CommandDefinition;
import com.abhisek.asep.architecture.domain.repository.CommandDefinitionRepository;
import com.abhisek.asep.architecture.infrastructure.mapper.CommandDefinitionPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.repository.JpaCommandDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CommandDefinitionRepositoryAdapter
        implements CommandDefinitionRepository {

    private final JpaCommandDefinitionRepository repository;

    private final CommandDefinitionPersistenceMapper mapper;

    @Override
    public CommandDefinition save(
            CommandDefinition command) {

        return mapper.toDomain(
                repository.save(
                        mapper.toEntity(command)));

    }

    @Override
    public Optional<CommandDefinition> findById(
            String id) {

        return repository.findById(id)
                .map(mapper::toDomain);

    }

    @Override
    public List<CommandDefinition> findByAggregateId(
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