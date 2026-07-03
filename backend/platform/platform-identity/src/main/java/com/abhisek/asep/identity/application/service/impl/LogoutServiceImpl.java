package com.abhisek.asep.identity.application.service.impl;

import com.abhisek.asep.identity.application.service.LogoutService;
import com.abhisek.asep.identity.domain.repository.RefreshTokenRepository;
import com.abhisek.asep.identity.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutServiceImpl implements LogoutService {

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public void logout(String username) {

        userRepository.findByUsername(username)
                .ifPresent(user ->
                        refreshTokenRepository.deleteByUserId(user.getId()));

    }
}