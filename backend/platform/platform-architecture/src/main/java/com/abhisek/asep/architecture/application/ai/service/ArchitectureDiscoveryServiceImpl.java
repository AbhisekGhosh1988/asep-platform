package com.abhisek.asep.architecture.application.ai.service;

import com.abhisek.asep.architecture.application.ai.dto.ArchitectureDiscoveryResponse;
import com.abhisek.asep.architecture.application.ai.workflow.ArchitectureDiscoveryWorkflow;
import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.domain.repository.RequirementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArchitectureDiscoveryServiceImpl implements ArchitectureDiscoveryService {

    private final RequirementRepository requirementRepository;

    private final ArchitectureDiscoveryWorkflow workflow;

    @Override
    public ArchitectureDiscoveryResponse discover(String projectId) {

        List<Requirement> requirements = requirementRepository.findByProjectId(projectId);

        if (requirements.isEmpty()) {

            throw new IllegalArgumentException("No requirements found for project: " + projectId);

        }

        String promptInput = buildPrompt(requirements);

        return workflow.execute(promptInput);

    }

    /**
     * Converts structured requirements into AI input.
     */
    private String buildPrompt(List<Requirement> requirements) {

        StringBuilder builder = new StringBuilder();

        for (Requirement requirement : requirements) {

            builder.append("Requirement\n").append("Title: ").append(requirement.getTitle()).append("\n")

                    .append("Type: ").append(requirement.getType()).append("\n")

                    .append("Priority: ").append(requirement.getPriority()).append("\n")

                    .append("Description:\n").append(requirement.getDescription()).append("\n\n");

        }

        return builder.toString();

    }

}