package com.abhisek.asep.architecture.infrastructure.persistence.adapter;

import com.abhisek.asep.architecture.domain.model.DomainServiceDefinition;
import com.abhisek.asep.architecture.domain.repository.DomainServiceDefinitionRepository;
import com.abhisek.asep.architecture.infrastructure.mapper.DomainServiceDefinitionPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.repository.JpaDomainServiceDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DomainServiceDefinitionRepositoryAdapter implements DomainServiceDefinitionRepository {

    private final JpaDomainServiceDefinitionRepository repository;

    private final DomainServiceDefinitionPersistenceMapper mapper;

    @Override
    public DomainServiceDefinition save(DomainServiceDefinition domainService) {

        return mapper.toDomain(repository.save(mapper.toEntity(domainService)));

    }

    @Override
    public Optional<DomainServiceDefinition> findById(String id) {

        return repository.findById(id).map(mapper::toDomain);

    }

    @Override
    public List<DomainServiceDefinition> findByAggregateId(String aggregateId) {

        return repository.findByAggregateId(aggregateId).stream().map(mapper::toDomain).toList();

    }

    @Override
    public boolean existsByAggregateIdAndName(String aggregateId, String name) {

        return repository.existsByAggregateIdAndName(aggregateId, name);

    }

}