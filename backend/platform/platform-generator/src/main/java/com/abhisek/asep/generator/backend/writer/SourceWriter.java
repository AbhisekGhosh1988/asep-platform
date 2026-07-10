package com.abhisek.asep.generator.backend.writer;

import java.io.IOException;
import java.nio.file.Path;

public interface SourceWriter {

    Path write(
            Path file,
            String source)
            throws IOException;

}