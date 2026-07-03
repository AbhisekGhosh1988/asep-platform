package com.abhisek.asep.identity.application.usecase.impl;


import com.abhisek.asep.identity.application.dto.request.LoginRequest;
import com.abhisek.asep.identity.application.dto.response.LoginResponse;
import com.abhisek.asep.identity.application.service.AuthenticationService;
import com.abhisek.asep.identity.application.usecase.LoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {
    private final AuthenticationService authenticationService;

    @Override
    public LoginResponse execute(LoginRequest request) {
        return authenticationService.login(request);
    }

}