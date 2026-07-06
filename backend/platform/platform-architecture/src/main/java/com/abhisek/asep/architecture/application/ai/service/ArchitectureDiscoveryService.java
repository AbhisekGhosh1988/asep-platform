package com.abhisek.asep.architecture.application.ai.service;

import com.abhisek.asep.architecture.application.ai.dto.ArchitectureDiscoveryResponse;

public interface ArchitectureDiscoveryService {

    ArchitectureDiscoveryResponse discover(String projectId);

}