package com.abhisek.asep.architecture.application.design.apicontract.imports.service;

import com.abhisek.asep.architecture.application.design.apicontract.imports.dto.request.ApiContractImportRequest;
import com.abhisek.asep.architecture.application.design.apicontract.imports.dto.response.ApiContractImportResponse;
import com.abhisek.asep.architecture.application.design.apicontract.imports.mapper.ApiContractImportMapper;
import com.abhisek.asep.architecture.domain.model.ApiContract;
import com.abhisek.asep.architecture.domain.repository.ApiContractRepository;
import com.abhisek.asep.core.application.usecase.AbstractCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ApiContractImportServiceImpl extends AbstractCreateUseCase implements ApiContractImportService {

    private final ApiContractRepository repository;

    private final ApiContractImportMapper mapper;

    @Override
    public ApiContractImportResponse importApiContract(ApiContractImportRequest request) {

        if (repository.existsByAggregateIdAndName(request.getAggregateId(), request.getName())) {

            throw new IllegalArgumentException("API Contract already exists.");

        }

        ApiContract apiContract = mapper.toApiContract(request);

        apiContract.setId(newId());
        apiContract.setCreatedAt(now());
        apiContract.setUpdatedAt(now());
        apiContract.setCreatedBy(currentUser());
        apiContract.setUpdatedBy(currentUser());

        apiContract = repository.save(apiContract);

        return ApiContractImportResponse.builder().apiContractId(apiContract.getId()).build();

    }

}