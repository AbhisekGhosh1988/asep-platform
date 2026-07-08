package com.abhisek.asep.generator.compiler.context;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompilerOptions {

    @Builder.Default
    private boolean enableSemanticValidation = true;

    @Builder.Default
    private boolean enableDependencyAnalysis = true;

    @Builder.Default
    private boolean enableOptimization = true;

    @Builder.Default
    private boolean failFast = true;

    @Builder.Default
    private boolean overwriteExistingFiles = true;

}