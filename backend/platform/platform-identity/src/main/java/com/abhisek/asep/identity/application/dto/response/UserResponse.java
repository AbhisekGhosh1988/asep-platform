package com.abhisek.asep.identity.application.dto.response;

import lombok.Builder;

@Builder
public record UserResponse(

        String id,

        String username,

        String email,

        String firstName,

        String lastName

) {
}