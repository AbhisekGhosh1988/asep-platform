package com.abhisek.asep.generator.backend.writer;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class DefaultSourceWriter implements SourceWriter {

    @Override
    public Path write(Path file, String source) throws IOException {

        Files.createDirectories(file.getParent());

        Files.writeString(file, source);

        return file;

    }

}