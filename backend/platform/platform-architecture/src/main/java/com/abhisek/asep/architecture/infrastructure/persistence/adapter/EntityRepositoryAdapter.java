package com.abhisek.asep.architecture.infrastructure.persistence.adapter;

import com.abhisek.asep.architecture.domain.model.Entity;
import com.abhisek.asep.architecture.domain.repository.EntityRepository;
import com.abhisek.asep.architecture.infrastructure.mapper.EntityPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.repository.JpaEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EntityRepositoryAdapter implements EntityRepository {

    private final JpaEntityRepository repository;

    private final EntityPersistenceMapper mapper;

    @Override
    public Entity save(Entity entity) {

        return mapper.toDomain(repository.save(mapper.toEntity(entity)));

    }

    @Override
    public Optional<Entity> findById(String id) {

        return repository.findById(id).map(mapper::toDomain);

    }

    @Override
    public List<Entity> findByAggregateId(String aggregateId) {

        return repository.findByAggregateId(aggregateId).stream().map(mapper::toDomain).toList();

    }

}