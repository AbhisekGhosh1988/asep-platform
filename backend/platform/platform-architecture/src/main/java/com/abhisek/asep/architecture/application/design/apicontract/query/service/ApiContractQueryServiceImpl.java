package com.abhisek.asep.architecture.application.design.apicontract.query.service;

import com.abhisek.asep.architecture.application.design.apicontract.query.dto.ApiContractDetailsResponse;
import com.abhisek.asep.architecture.application.design.apicontract.query.mapper.ApiContractQueryMapper;
import com.abhisek.asep.architecture.domain.repository.ApiContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiContractQueryServiceImpl
        implements ApiContractQueryService {

    private final ApiContractRepository repository;

    private final ApiContractQueryMapper mapper;

    @Override
    public ApiContractDetailsResponse getApiContract(
            String apiContractId) {

        return repository.findById(apiContractId)
                .map(mapper::toResponse)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "API Contract not found : "
                                        + apiContractId));

    }

    @Override
    public List<ApiContractDetailsResponse> getApiContracts(
            String aggregateId) {

        return repository.findByAggregateId(aggregateId)
                .stream()
                .map(mapper::toResponse)
                .toList();

    }

}