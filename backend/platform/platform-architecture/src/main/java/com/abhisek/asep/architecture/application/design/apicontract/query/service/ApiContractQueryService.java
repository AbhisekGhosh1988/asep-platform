package com.abhisek.asep.architecture.application.design.apicontract.query.service;

import com.abhisek.asep.architecture.application.design.apicontract.query.dto.ApiContractDetailsResponse;

import java.util.List;

public interface ApiContractQueryService {

    ApiContractDetailsResponse getApiContract(
            String apiContractId);

    List<ApiContractDetailsResponse> getApiContracts(
            String aggregateId);

}