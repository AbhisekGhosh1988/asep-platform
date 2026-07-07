package com.abhisek.asep.architecture.application.design.attribute.service;

import com.abhisek.asep.architecture.application.design.attribute.ai.dto.AttributeDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.attribute.ai.workflow.AttributeDiscoveryWorkflow;
import com.abhisek.asep.architecture.application.design.entity.query.dto.EntityDetailsResponse;
import com.abhisek.asep.architecture.application.design.entity.query.service.EntityQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttributeDiscoveryServiceImpl implements AttributeDiscoveryService {

    private final EntityQueryService entityQueryService;

    private final AttributeDiscoveryWorkflow workflow;

    @Override
    public AttributeDiscoveryResponse discover(String entityId) {

        EntityDetailsResponse entity = entityQueryService.getEntity(entityId);

        return workflow.execute(buildPrompt(entity));

    }

    private String buildPrompt(EntityDetailsResponse entity) {

        StringBuilder builder = new StringBuilder();

        builder.append("Entity\n\n");

        builder.append("Name: ").append(entity.getName()).append("\n");

        builder.append("Description: ").append(entity.getDescription()).append("\n");

        builder.append("Root Entity: ").append(entity.getRootEntity()).append("\n");

        return builder.toString();

    }

}