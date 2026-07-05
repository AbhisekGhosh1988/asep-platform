package com.abhisek.asep.requirements.application.versioning;

import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.domain.snapshot.RequirementSnapshot;
import org.springframework.stereotype.Component;

@Component
public class RequirementSnapshotFactory {

    public RequirementSnapshot fromRequirement(Requirement requirement) {
        if (requirement == null) {
            return null;
        }
        return RequirementSnapshot.builder().id(requirement.getId()).projectId(requirement.getProjectId()).
                title(requirement.getTitle()).description(requirement.getDescription()).type(requirement.getType()).
                status(requirement.getStatus()).priority(requirement.getPriority()).
                complexity(requirement.getComplexity()).source(requirement.getSource()).
                risk(requirement.getRisk()).version(requirement.getVersion()).
                parentRequirementId(requirement.getParentRequirementId()).tags(requirement.getTags()).
                approvedBy(requirement.getApprovedBy()).build();
    }

    public Requirement toRequirement(RequirementSnapshot snapshot) {
        if (snapshot == null) {
            return null;
        }
        Requirement requirement = new Requirement();
        requirement.setId(snapshot.getId());
        requirement.setProjectId(snapshot.getProjectId());
        requirement.setTitle(snapshot.getTitle());
        requirement.setDescription(snapshot.getDescription());
        requirement.setType(snapshot.getType());
        requirement.setStatus(snapshot.getStatus());
        requirement.setPriority(snapshot.getPriority());
        requirement.setComplexity(snapshot.getComplexity());
        requirement.setSource(snapshot.getSource());
        requirement.setRisk(snapshot.getRisk());
        requirement.setVersion(snapshot.getVersion());
        requirement.setParentRequirementId(snapshot.getParentRequirementId());
        requirement.setTags(snapshot.getTags());
        requirement.setApprovedBy(snapshot.getApprovedBy());

        return requirement;
    }
}