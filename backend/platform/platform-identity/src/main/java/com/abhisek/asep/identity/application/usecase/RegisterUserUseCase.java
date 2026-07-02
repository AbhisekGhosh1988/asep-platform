package com.abhisek.asep.identity.application.usecase;

import com.abhisek.asep.identity.application.dto.response.UserResponse;
import com.abhisek.asep.identity.application.dto.request.RegisterUserRequest;

public interface RegisterUserUseCase {

    UserResponse execute(RegisterUserRequest request);

}