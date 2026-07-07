package com.abhisek.asep.architecture.infrastructure.persistence.adapter;

import com.abhisek.asep.architecture.domain.model.Aggregate;
import com.abhisek.asep.architecture.domain.repository.AggregateRepository;
import com.abhisek.asep.architecture.infrastructure.mapper.AggregatePersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.repository.JpaAggregateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AggregateRepositoryAdapter implements AggregateRepository {

    private final JpaAggregateRepository repository;

    private final AggregatePersistenceMapper mapper;

    @Override
    public Aggregate save(Aggregate aggregate) {

        return mapper.toDomain(repository.save(mapper.toEntity(aggregate)));

    }

    @Override
    public Optional<Aggregate> findById(String id) {

        return repository.findById(id).map(mapper::toDomain);

    }

    @Override
    public List<Aggregate> findByMicroserviceId(String microserviceId) {

        return repository.findByMicroserviceId(microserviceId).stream().map(mapper::toDomain).toList();

    }

}