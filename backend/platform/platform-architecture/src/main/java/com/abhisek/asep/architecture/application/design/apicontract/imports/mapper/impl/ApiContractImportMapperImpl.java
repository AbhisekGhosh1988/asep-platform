package com.abhisek.asep.architecture.application.design.apicontract.imports.mapper.impl;

import com.abhisek.asep.architecture.application.design.apicontract.imports.dto.request.ApiContractImportRequest;
import com.abhisek.asep.architecture.application.design.apicontract.imports.mapper.ApiContractImportMapper;
import com.abhisek.asep.architecture.domain.model.ApiContract;
import org.springframework.stereotype.Component;

@Component
public class ApiContractImportMapperImpl
        implements ApiContractImportMapper {

    @Override
    public ApiContract toApiContract(
            ApiContractImportRequest request) {

        return ApiContract.builder()
                .aggregateId(request.getAggregateId())
                .name(request.getName())
                .method(request.getMethod())
                .path(request.getPath())
                .description(request.getDescription())
                .build();

    }

}