package com.abhisek.asep.identity.application.dto.response;

import lombok.Builder;

@Builder
public record PermissionResponse(

        String id,

        String name,

        String description

) {
}