package com.abhisek.asep.identity.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Authentication and JWT APIs")
public class AuthenticationController extends BaseController {

    private final LoginUseCase loginUseCase;
    private final RefreshTokenService refreshTokenService;
    private final LogoutService logoutService;
    private final CurrentUserService currentUserService;
    private final RegisterUserUseCase registerUserUseCase;

    @PostMapping("/login")
    @Operation(summary = "Authenticate user", description = "Authenticates user and returns access and refresh tokens.")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@Valid @RequestBody LoginRequest request) {

        return ok("Login successful", loginUseCase.execute(request));
    }

    @PostMapping("/refresh")
    @Operation(summary = "Refresh access token", description = "Generates a new access token using a refresh token.")
    public ResponseEntity<ApiResponse<RefreshTokenResponse>> refreshToken(@Valid @RequestBody RefreshTokenRequest request) {

        return ok("Token refreshed successfully", refreshTokenService.refresh(request));
    }

    @PostMapping("/logout")
    @Operation(summary = "Logout", description = "Revokes the current refresh token.")
    public ResponseEntity<ApiResponse<Void>> logout() {

        logoutService.logout(SecurityUtils.currentUsername());
        return deleted("Logout successful");
    }

    @GetMapping("/me")
    @Operation(summary = "Current user", description = "Returns the authenticated user.")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<CurrentUserResponse>> me() {

        return ok("Current user", currentUserService.currentUser());
    }

    @PostMapping("/register")
    @Operation(summary = "Register new user", description = "Registers a new ASEP user.")
    public ResponseEntity<ApiResponse<UserResponse>> register(@Valid @RequestBody RegisterUserRequest request) {

        return created("User registered successfully", registerUserUseCase.execute(request));
    }
}