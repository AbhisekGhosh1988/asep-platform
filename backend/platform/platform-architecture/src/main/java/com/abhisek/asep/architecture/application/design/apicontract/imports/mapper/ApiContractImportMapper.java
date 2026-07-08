package com.abhisek.asep.architecture.application.design.apicontract.imports.mapper;

import com.abhisek.asep.architecture.application.design.apicontract.imports.dto.request.ApiContractImportRequest;
import com.abhisek.asep.architecture.domain.model.ApiContract;

public interface ApiContractImportMapper {

    ApiContract toApiContract(
            ApiContractImportRequest request);

}