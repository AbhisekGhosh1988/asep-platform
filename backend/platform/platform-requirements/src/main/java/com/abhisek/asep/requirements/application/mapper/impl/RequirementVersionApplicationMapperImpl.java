package com.abhisek.asep.requirements.application.mapper.impl;

import com.abhisek.asep.requirements.application.dto.response.RequirementVersionResponse;
import com.abhisek.asep.requirements.application.mapper.RequirementVersionApplicationMapper;
import com.abhisek.asep.requirements.domain.model.RequirementVersion;
import org.springframework.stereotype.Component;

@Component
public class RequirementVersionApplicationMapperImpl implements RequirementVersionApplicationMapper {
    @Override
    public RequirementVersionResponse toResponse(RequirementVersion version) {

        if (version == null) {
            return null;
        }

        return RequirementVersionResponse.builder().id(String.valueOf(version.getId())).version(version.getVersion()).createdBy(version.getCreatedBy()).createdAt(version.getCreatedAt()).build();
    }
}
