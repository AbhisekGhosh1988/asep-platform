package com.abhisek.asep.architecture.application.design.apicontract.imports.service;

import com.abhisek.asep.architecture.application.design.apicontract.imports.dto.request.ApiContractImportRequest;
import com.abhisek.asep.architecture.application.design.apicontract.imports.dto.response.ApiContractImportResponse;

public interface ApiContractImportService {

    ApiContractImportResponse importApiContract(
            ApiContractImportRequest request);

}