package com.abhisek.asep.architecture.application.design.apicontract.query.mapper;

import com.abhisek.asep.architecture.application.design.apicontract.query.dto.ApiContractDetailsResponse;
import com.abhisek.asep.architecture.domain.model.ApiContract;

public interface ApiContractQueryMapper {

    ApiContractDetailsResponse toResponse(
            ApiContract apiContract);

}