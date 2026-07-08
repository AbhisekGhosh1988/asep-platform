package com.abhisek.asep.generator.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GenerationMetadata {

    private String generatedBy;

    private Instant generatedAt;

    private String platformVersion;

    private String modelVersion;

}