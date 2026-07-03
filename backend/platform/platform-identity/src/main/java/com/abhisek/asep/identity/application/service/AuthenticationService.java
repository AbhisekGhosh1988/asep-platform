package com.abhisek.asep.identity.application.service;

import com.abhisek.asep.identity.application.dto.request.LoginRequest;
import com.abhisek.asep.identity.application.dto.response.LoginResponse;

public interface AuthenticationService {

    LoginResponse login(LoginRequest request);

}