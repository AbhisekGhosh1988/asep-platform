package com.abhisek.asep.identity.application.service.impl;

import com.abhisek.asep.common.enums.ErrorCode;
import com.abhisek.asep.common.exception.ASEPException;
import com.abhisek.asep.identity.application.dto.request.RefreshTokenRequest;
import com.abhisek.asep.identity.application.dto.response.RefreshTokenResponse;
import com.abhisek.asep.identity.application.service.RefreshTokenService;
import com.abhisek.asep.identity.domain.exception.RefreshTokenNotFoundException;
import com.abhisek.asep.identity.domain.exception.UserNotFoundException;
import com.abhisek.asep.identity.domain.model.RefreshToken;
import com.abhisek.asep.identity.domain.model.User;
import com.abhisek.asep.identity.domain.repository.RefreshTokenRepository;
import com.abhisek.asep.identity.domain.repository.UserRepository;
import com.abhisek.asep.identity.infrastructure.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Transactional
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    @Value("${asep.security.jwt.refresh-token-validity}")
    private long refreshTokenValidity;

    @Override
    public RefreshTokenResponse refresh(RefreshTokenRequest request) {

        // Validate refresh token
        RefreshToken refreshToken = refreshTokenRepository.findByToken(request.getRefreshToken()).
                orElseThrow(() -> new RefreshTokenNotFoundException("Refresh token not found"));

        // Check revoked
        if (refreshToken.isRevoked()) {
            throw new ASEPException(ErrorCode.TOKEN_INVALID, "Refresh token has been revoked");
        }
        // Check expiry
        if (refreshToken.isExpired()) {
            throw new ASEPException(ErrorCode.TOKEN_EXPIRED, "Refresh token has expired");
        }
        // Load user
        User user = userRepository.findById(refreshToken.getUserId()).
                orElseThrow(() -> new UserNotFoundException("User not found"));

        // Revoke old refresh token
        refreshToken.setRevoked(true);

        refreshTokenRepository.save(refreshToken);

        // Generate new tokens
        String accessToken = jwtService.generateAccessToken(user);

        String newRefreshToken = jwtService.generateRefreshToken(user);

        // Persist new refresh token
        RefreshToken newToken = RefreshToken.builder().token(newRefreshToken).
                userId(user.getId()).expiryDate(Instant.now().plusMillis(refreshTokenValidity)).
                revoked(false).build();

        refreshTokenRepository.save(newToken);

        // Response
        return RefreshTokenResponse.builder().accessToken(accessToken).
                refreshToken(newRefreshToken).tokenType("Bearer").expiresIn(3600).build();
    }
}