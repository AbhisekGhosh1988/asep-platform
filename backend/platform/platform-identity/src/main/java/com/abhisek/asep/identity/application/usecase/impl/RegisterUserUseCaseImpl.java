package com.abhisek.asep.identity.application.usecase.impl;

import com.abhisek.asep.identity.application.dto.response.UserResponse;
import com.abhisek.asep.identity.application.dto.request.RegisterUserRequest;
import com.abhisek.asep.identity.application.service.UserService;
import com.abhisek.asep.identity.application.usecase.RegisterUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterUserUseCaseImpl implements RegisterUserUseCase {

    private final UserService userService;

    @Override
    public UserResponse execute(RegisterUserRequest request) {
        return userService.register(request);
    }
}