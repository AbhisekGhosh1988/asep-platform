package com.abhisek.asep.generator.backend.context;

import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Component
public class DefaultGenerationContext
        implements GenerationContext {

    private final Path outputRoot =
            Path.of("output");

    private final Path projectRoot =
            outputRoot.resolve("generated-service");

    @Override
    public Path getOutputRoot() {

        return outputRoot;

    }

    @Override
    public Path getProjectRoot() {

        return projectRoot;

    }

    @Override
    public Path getJavaSourceRoot() {

        return projectRoot.resolve(
                "src/main/java");

    }

    @Override
    public Path getResourceRoot() {

        return projectRoot.resolve(
                "src/main/resources");

    }

    @Override
    public Path getTestSourceRoot() {

        return projectRoot.resolve(
                "src/test/java");

    }

    @Override
    public String getBasePackage() {

        return "com.abhisek.generated";

    }

    @Override
    public Path resolveJavaFile(
            String packageName,
            String className) {

        return getJavaSourceRoot()
                .resolve(
                        packageName.replace('.', '/'))
                .resolve(className + ".java");

    }

    @Override
    public Path resolveResource(
            String fileName) {

        return getResourceRoot()
                .resolve(fileName);

    }

    @Override
    public Path resolveJavaTestFile(
            String packageName,
            String className) {

        String relativePackage =
                packageName.replace('.', '/');

        return getTestSourceRoot()
                .resolve(relativePackage)
                .resolve(className + ".java");

    }

}