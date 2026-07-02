package com.abhisek.asep.identity.application.service;

import com.abhisek.asep.identity.application.dto.request.RegisterUserRequest;
import com.abhisek.asep.identity.application.dto.response.UserResponse;

public interface UserService {

    UserResponse register(RegisterUserRequest request);

}