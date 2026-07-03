package com.abhisek.asep.web.advice;

public record ValidationError(

        String field,

        String message

) {
}