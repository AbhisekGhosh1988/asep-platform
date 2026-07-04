package com.abhisek.asep.identity.application.service.impl;

import com.abhisek.asep.identity.application.dto.request.LoginRequest;
import com.abhisek.asep.identity.application.dto.response.LoginResponse;
import com.abhisek.asep.identity.application.service.AuthenticationService;
import com.abhisek.asep.identity.domain.exception.UserNotFoundException;
import com.abhisek.asep.identity.domain.model.RefreshToken;
import com.abhisek.asep.identity.domain.model.User;
import com.abhisek.asep.identity.domain.repository.RefreshTokenRepository;
import com.abhisek.asep.identity.domain.repository.UserRepository;
import com.abhisek.asep.identity.infrastructure.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public LoginResponse login(LoginRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UserNotFoundException("User not found: " + request.getUsername()));
        String refreshToken = jwtService.generateRefreshToken(user);

        RefreshToken token = RefreshToken.builder().token(refreshToken).userId(user.getId()).expiryDate(Instant.now().plusSeconds(604800)).revoked(false).build();

        refreshTokenRepository.save(token);
        return LoginResponse.builder().accessToken(jwtService.generateAccessToken(user)).refreshToken(refreshToken).tokenType("Bearer").expiresIn(3600).build();
    }
}