package com.abhisek.asep.architecture.application.design.apicontract.query.mapper.impl;

import com.abhisek.asep.architecture.application.design.apicontract.query.dto.ApiContractDetailsResponse;
import com.abhisek.asep.architecture.application.design.apicontract.query.mapper.ApiContractQueryMapper;
import com.abhisek.asep.architecture.domain.model.ApiContract;
import org.springframework.stereotype.Component;

@Component
public class ApiContractQueryMapperImpl implements ApiContractQueryMapper {

    @Override
    public ApiContractDetailsResponse toResponse(ApiContract apiContract) {

        if (apiContract == null) {
            return null;
        }

        return ApiContractDetailsResponse.builder().id(apiContract.getId()).aggregateId(apiContract.getAggregateId()).name(apiContract.getName()).method(apiContract.getMethod()).path(apiContract.getPath()).description(apiContract.getDescription()).build();

    }

}