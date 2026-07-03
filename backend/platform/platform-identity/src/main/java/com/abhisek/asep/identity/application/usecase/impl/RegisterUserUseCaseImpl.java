package com.abhisek.asep.identity.application.usecase.impl;

import com.abhisek.asep.common.enums.ErrorCode;
import com.abhisek.asep.common.exception.ASEPException;
import com.abhisek.asep.identity.application.dto.response.UserResponse;
import com.abhisek.asep.identity.application.dto.request.RegisterUserRequest;
import com.abhisek.asep.identity.application.service.UserService;
import com.abhisek.asep.identity.application.usecase.RegisterUserUseCase;
import com.abhisek.asep.identity.domain.exception.DuplicateUserException;
import com.abhisek.asep.identity.infrastructure.persistence.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterUserUseCaseImpl implements RegisterUserUseCase {

    private final UserService userService;
    private final JpaUserRepository userRepository;

    @Override
    public UserResponse execute(RegisterUserRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new DuplicateUserException("Username already exists: " + request.getUsername());
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ASEPException(ErrorCode.EMAIL_ALREADY_EXISTS,
                    "Email already exists: " + request.getEmail());
        }
        return userService.register(request);
    }
}