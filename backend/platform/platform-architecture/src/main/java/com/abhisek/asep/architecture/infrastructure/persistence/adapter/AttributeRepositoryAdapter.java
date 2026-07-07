package com.abhisek.asep.architecture.infrastructure.persistence.adapter;

import com.abhisek.asep.architecture.domain.model.Attribute;
import com.abhisek.asep.architecture.domain.repository.AttributeRepository;
import com.abhisek.asep.architecture.infrastructure.mapper.AttributePersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.repository.JpaAttributeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AttributeRepositoryAdapter
        implements AttributeRepository {

    private final JpaAttributeRepository repository;

    private final AttributePersistenceMapper mapper;

    @Override
    public Attribute save(Attribute attribute) {
        return mapper.toDomain(
                repository.save(
                        mapper.toEntity(attribute)));
    }

    @Override
    public Optional<Attribute> findById(String id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Attribute> findByEntityId(String entityId) {
        return repository.findByEntityId(entityId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}