package com.abhisek.asep.requirements.application.mapper.impl;

import com.abhisek.asep.requirements.application.dto.request.CreateRequirementRequest;
import com.abhisek.asep.requirements.application.dto.request.UpdateRequirementRequest;
import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;
import com.abhisek.asep.requirements.application.dto.response.RequirementSummaryResponse;
import com.abhisek.asep.requirements.application.mapper.RequirementApplicationMapper;
import com.abhisek.asep.requirements.domain.model.Requirement;
import org.springframework.stereotype.Component;

@Component
public class RequirementApplicationMapperImpl implements RequirementApplicationMapper {
    @Override
    public Requirement toDomain(CreateRequirementRequest request) {

        if (request == null) {
            return null;
        }

        return Requirement.builder().title(request.getTitle()).description(request.getDescription()).type(request.getType()).priority(request.getPriority()).complexity(request.getComplexity()).source(request.getSource()).risk(request.getRisk()).parentRequirementId(request.getParentRequirementId()).tags(request.getTags()).build();

    }
    @Override
    public void updateDomain(Requirement requirement, UpdateRequirementRequest request) {

        requirement.setTitle(request.getTitle());
        requirement.setDescription(request.getDescription());
        requirement.setType(request.getType());
        requirement.setPriority(request.getPriority());
        requirement.setComplexity(request.getComplexity());
        requirement.setRisk(request.getRisk());
        requirement.setParentRequirementId(request.getParentRequirementId());
        requirement.setTags(request.getTags());

    }
    @Override
    public RequirementResponse toResponse(Requirement requirement) {

        if (requirement == null) {
            return null;
        }

        return RequirementResponse.builder()

                .id(requirement.getId()).projectId(requirement.getProjectId())

                .title(requirement.getTitle()).description(requirement.getDescription())

                .type(requirement.getType()).status(requirement.getStatus())

                .priority(requirement.getPriority()).complexity(requirement.getComplexity())

                .source(requirement.getSource()).risk(requirement.getRisk())

                .version(requirement.getVersion())

                .parentRequirementId(requirement.getParentRequirementId())

                .tags(requirement.getTags())

                .createdBy(requirement.getCreatedBy()).approvedBy(requirement.getApprovedBy())

                .createdAt(requirement.getCreatedAt()).updatedAt(requirement.getUpdatedAt())

                .build();

    }
    @Override
    public RequirementSummaryResponse toSummary(Requirement requirement) {

        if (requirement == null) {
            return null;
        }

        return RequirementSummaryResponse.builder()

                .id(requirement.getId()).title(requirement.getTitle())

                .type(requirement.getType()).status(requirement.getStatus()).priority(requirement.getPriority())

                .build();

    }
}
