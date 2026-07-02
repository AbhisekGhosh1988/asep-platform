package com.abhisek.asep.web.version;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VersionResponse {

    private String application;
    private String version;
    private String javaVersion;
    private String springBootVersion;
    private Instant timestamp;

}