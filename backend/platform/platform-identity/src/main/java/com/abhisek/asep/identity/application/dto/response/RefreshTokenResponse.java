package com.abhisek.asep.identity.application.dto.response;

import lombok.Builder;

@Builder
public record RefreshTokenResponse(

        String accessToken,

        String refreshToken,

        String tokenType,

        long expiresIn

) {
}