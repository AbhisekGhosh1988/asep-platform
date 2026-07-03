package com.abhisek.asep.identity.application.usecase;

import com.abhisek.asep.identity.application.dto.request.LoginRequest;
import com.abhisek.asep.identity.application.dto.response.LoginResponse;

public interface LoginUseCase {

    LoginResponse execute(LoginRequest request);

}