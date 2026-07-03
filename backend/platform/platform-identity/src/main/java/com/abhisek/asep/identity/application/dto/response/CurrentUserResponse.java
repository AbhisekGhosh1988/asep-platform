package com.abhisek.asep.identity.application.dto.response;

import lombok.Builder;

import java.util.Set;

@Builder
public record CurrentUserResponse(

        String id,

        String username,

        String email,

        Set<String> roles

) {
}