package com.abhisek.asep.identity.domain.event;

public record UserRegisteredEvent(
        String userId,
        String username,
        String email
) {
}