package com.abhisek.asep.architecture.infrastructure.persistence.adapter;

import com.abhisek.asep.architecture.domain.model.Microservice;
import com.abhisek.asep.architecture.domain.repository.MicroserviceRepository;
import com.abhisek.asep.architecture.infrastructure.mapper.MicroservicePersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.repository.JpaMicroserviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MicroserviceRepositoryAdapter
        implements MicroserviceRepository {

    private final JpaMicroserviceRepository repository;

    private final MicroservicePersistenceMapper mapper;

    @Override
    public Microservice save(Microservice microservice) {

        return mapper.toDomain(
                repository.save(
                        mapper.toEntity(microservice)));

    }

    @Override
    public Optional<Microservice> findById(String id) {

        return repository.findById(id)
                .map(mapper::toDomain);

    }

    @Override
    public List<Microservice> findByBoundedContextId(String boundedContextId) {

        return repository.findByBoundedContextId(boundedContextId)
                .stream()
                .map(mapper::toDomain)
                .toList();

    }

}