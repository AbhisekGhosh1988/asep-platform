package com.abhisek.asep.core.web;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.response.ApiResponseFactory;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

    protected <T> ResponseEntity<ApiResponse<T>> ok(String message, T data) {

        return ApiResponseFactory.ok(message, data);
    }

    protected <T> ResponseEntity<ApiResponse<T>> created(String message, T data) {

        return ApiResponseFactory.created(message, data);
    }

    protected ResponseEntity<ApiResponse<Void>> deleted(String message) {

        return ApiResponseFactory.noContent(message);
    }

}