package com.abhisek.asep.identity.application.dto.response;

import com.abhisek.asep.identity.domain.entity.RoleType;
import lombok.Builder;

@Builder
public record RoleResponse(

        String id,

        RoleType roleType

) {
}