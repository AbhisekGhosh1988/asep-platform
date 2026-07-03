package com.abhisek.asep.identity.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.identity.application.dto.request.LoginRequest;
import com.abhisek.asep.identity.application.dto.request.RefreshTokenRequest;
import com.abhisek.asep.identity.application.dto.request.RegisterUserRequest;
import com.abhisek.asep.identity.application.dto.response.CurrentUserResponse;
import com.abhisek.asep.identity.application.dto.response.LoginResponse;
import com.abhisek.asep.identity.application.dto.response.RefreshTokenResponse;
import com.abhisek.asep.identity.application.dto.response.UserResponse;
import com.abhisek.asep.identity.application.service.CurrentUserService;
import com.abhisek.asep.identity.application.service.LogoutService;
import com.abhisek.asep.identity.application.service.RefreshTokenService;
import com.abhisek.asep.identity.application.usecase.LoginUseCase;
import com.abhisek.asep.identity.application.usecase.RegisterUserUseCase;
import com.abhisek.asep.identity.infrastructure.security.SecurityUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final LoginUseCase loginUseCase;
    private final RefreshTokenService refreshTokenService;
    private final LogoutService logoutService;
    private final CurrentUserService currentUserService;
    private final RegisterUserUseCase registerUserUseCase;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(
            @Valid @RequestBody LoginRequest request) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Login successful",
                        loginUseCase.execute(request)
                )
        );

    }
    @PostMapping("/refresh")
    public ResponseEntity<ApiResponse<RefreshTokenResponse>> refreshToken(
            @Valid @RequestBody RefreshTokenRequest request) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Token refreshed successfully",
                        refreshTokenService.refresh(request)
                )
        );

    }
    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<Void>> logout() {

        logoutService.logout(SecurityUtils.currentUsername());

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Logout successful",
                        null
                )
        );

    }
    @GetMapping("/me")
    public ResponseEntity<ApiResponse<CurrentUserResponse>> me() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Current user",
                        currentUserService.currentUser()
                )
        );

    }
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> register(
            @Valid @RequestBody RegisterUserRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.success(
                                "User registered successfully",
                                registerUserUseCase.execute(request)
                        )
                );
    }
}