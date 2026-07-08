package com.abhisek.asep.generator.compiler.context;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompilerConfiguration {

    private String javaVersion;

    private String springBootVersion;

    private String targetDirectory;

    private String outputEncoding;

}