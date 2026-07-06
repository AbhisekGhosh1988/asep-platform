package com.abhisek.asep.architecture.infrastructure.persistence.adapter;

import com.abhisek.asep.architecture.domain.model.BoundedContext;
import com.abhisek.asep.architecture.domain.repository.BoundedContextRepository;
import com.abhisek.asep.architecture.infrastructure.mapper.BoundedContextPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.repository.JpaBoundedContextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoundedContextRepositoryAdapter
        implements BoundedContextRepository {

    private final JpaBoundedContextRepository repository;

    private final BoundedContextPersistenceMapper mapper;

    @Override
    public BoundedContext save(BoundedContext boundedContext) {

        return mapper.toDomain(
                repository.save(
                        mapper.toEntity(boundedContext)));

    }

    @Override
    public Optional<BoundedContext> findById(String id) {

        return repository.findById(id)
                .map(mapper::toDomain);

    }

    @Override
    public List<BoundedContext> findByArchitectureId(String architectureId) {

        return repository.findByArchitectureId(architectureId)
                .stream()
                .map(mapper::toDomain)
                .toList();

    }

}