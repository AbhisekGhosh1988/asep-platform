package com.abhisek.asep.generator.backend.context;

import java.nio.file.Path;

public interface GenerationContext {

    Path getOutputRoot();

    Path getProjectRoot();

    Path getJavaSourceRoot();

    Path getResourceRoot();

    Path getTestSourceRoot();

    String getBasePackage();

    Path resolveJavaFile(
            String packageName,
            String className);

    Path resolveResource(
            String fileName);

    Path resolveJavaTestFile(
            String packageName,
            String className);

}