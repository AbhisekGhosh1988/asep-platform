package com.abhisek.asep.architecture.application.design.domainservice.query.service;

import com.abhisek.asep.architecture.application.design.domainservice.query.dto.DomainServiceDefinitionDetailsResponse;

import java.util.List;

public interface DomainServiceDefinitionQueryService {

    DomainServiceDefinitionDetailsResponse getDomainService(
            String domainServiceId);

    List<DomainServiceDefinitionDetailsResponse> getDomainServices(
            String aggregateId);

}