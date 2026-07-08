package com.abhisek.asep.architecture.infrastructure.persistence.adapter;

import com.abhisek.asep.architecture.domain.model.ApiContract;
import com.abhisek.asep.architecture.domain.repository.ApiContractRepository;
import com.abhisek.asep.architecture.infrastructure.mapper.ApiContractPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.repository.JpaApiContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ApiContractRepositoryAdapter implements ApiContractRepository {

    private final JpaApiContractRepository repository;

    private final ApiContractPersistenceMapper mapper;

    @Override
    public ApiContract save(ApiContract apiContract) {

        return mapper.toDomain(repository.save(mapper.toEntity(apiContract)));

    }

    @Override
    public Optional<ApiContract> findById(String id) {

        return repository.findById(id).map(mapper::toDomain);

    }

    @Override
    public List<ApiContract> findByAggregateId(String aggregateId) {

        return repository.findByAggregateId(aggregateId).stream().map(mapper::toDomain).toList();

    }

    @Override
    public boolean existsByAggregateIdAndName(String aggregateId, String name) {

        return repository.existsByAggregateIdAndName(aggregateId, name);

    }

}