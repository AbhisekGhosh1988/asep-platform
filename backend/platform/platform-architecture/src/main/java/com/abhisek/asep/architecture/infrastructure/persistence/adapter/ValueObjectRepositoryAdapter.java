package com.abhisek.asep.architecture.infrastructure.persistence.adapter;

import com.abhisek.asep.architecture.domain.model.ValueObject;
import com.abhisek.asep.architecture.domain.repository.ValueObjectRepository;
import com.abhisek.asep.architecture.infrastructure.mapper.ValueObjectPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.repository.JpaValueObjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ValueObjectRepositoryAdapter
        implements ValueObjectRepository {

    private final JpaValueObjectRepository repository;

    private final ValueObjectPersistenceMapper mapper;

    @Override
    public ValueObject save(ValueObject valueObject) {

        return mapper.toDomain(
                repository.save(
                        mapper.toEntity(valueObject)));

    }

    @Override
    public Optional<ValueObject> findById(String id) {

        return repository.findById(id)
                .map(mapper::toDomain);

    }

    @Override
    public List<ValueObject> findByAggregateId(
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