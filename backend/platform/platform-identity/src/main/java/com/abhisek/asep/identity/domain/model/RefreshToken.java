package com.abhisek.asep.identity.domain.model;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken {

    private String id;

    private String token;

    private String userId;

    private Instant expiryDate;

    private boolean revoked;

    @Builder.Default
    private Instant createdAt = Instant.now();

    public boolean isExpired() {
        return expiryDate.isBefore(Instant.now());
    }

    public void revoke() {
        this.revoked = true;
    }
}