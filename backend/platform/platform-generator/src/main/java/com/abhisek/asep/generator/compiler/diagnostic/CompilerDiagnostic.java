package com.abhisek.asep.generator.compiler.diagnostic;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompilerDiagnostic {

    /**
     * Unique diagnostic code.
     */
    private String code;

    /**
     * Severity.
     */
    private DiagnosticSeverity severity;

    /**
     * Human readable message.
     */
    private String message;

    /**
     * Source artifact.
     */
    private String source;

    /**
     * Optional location.
     */
    private String location;

}