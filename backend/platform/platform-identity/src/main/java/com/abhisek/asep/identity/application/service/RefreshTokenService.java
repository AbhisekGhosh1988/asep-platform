package com.abhisek.asep.identity.application.service;

import com.abhisek.asep.identity.application.dto.request.RefreshTokenRequest;
import com.abhisek.asep.identity.application.dto.response.RefreshTokenResponse;

public interface RefreshTokenService {

    RefreshTokenResponse refresh(RefreshTokenRequest request);

}