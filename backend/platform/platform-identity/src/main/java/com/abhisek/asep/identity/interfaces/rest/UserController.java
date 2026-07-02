package com.abhisek.asep.identity.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.identity.application.dto.request.RegisterUserRequest;
import com.abhisek.asep.identity.application.dto.response.UserResponse;
import com.abhisek.asep.identity.application.usecase.RegisterUserUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;
    @PostMapping
    public ApiResponse<UserResponse> register(
            @Valid @RequestBody RegisterUserRequest request) {

        return ApiResponse.success(
                "User registered successfully",
                registerUserUseCase.execute(request));
    }

}