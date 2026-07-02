package com.abhisek.asep.web.info;

import java.time.Instant;

public record BuildInfoResponse(
        String application,
        String version,
        String javaVersion,
        String springBootVersion,
        Instant timestamp) {
}