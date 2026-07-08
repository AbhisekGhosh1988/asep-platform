package com.abhisek.asep.architecture.application.design.apicontract.service;

import com.abhisek.asep.architecture.application.design.apicontract.ai.dto.ApiContractDiscoveryResponse;

public interface ApiContractDiscoveryService {

    ApiContractDiscoveryResponse discover(
            String aggregateId);

}