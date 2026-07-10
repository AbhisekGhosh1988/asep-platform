package com.abhisek.asep.generator.backend.java.bootstrap;

import com.abhisek.asep.generator.backend.context.GenerationContext;
import com.abhisek.asep.generator.backend.template.Template;
import com.abhisek.asep.generator.backend.template.TemplateContext;
import com.abhisek.asep.generator.backend.template.TemplateEngine;
import com.abhisek.asep.generator.backend.template.TemplateRepository;
import com.abhisek.asep.generator.backend.writer.SourceWriter;
import com.abhisek.asep.generator.compiler.pipeline.CompilerResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;

@Slf4j
@Component
@RequiredArgsConstructor
public class DefaultReadmeGenerator
        implements ReadmeGenerator {

    private final TemplateRepository templateRepository;

    private final TemplateEngine templateEngine;

    private final SourceWriter sourceWriter;

    @Override
    public void generate(
            CompilerResult compilerResult,
            GenerationContext generationContext) {

        Template template =
                templateRepository.load(
                        "README.md.tpl");

        TemplateContext context =
                new TemplateContext()
                        .put(
                                "applicationName",
                                "generated-service");

        String source =
                templateEngine.render(
                        template,
                        context);

        Path readmePath =
                generationContext.getProjectRoot()
                        .resolve("README.md");

        try {

            sourceWriter.write(
                    readmePath,
                    source);

        } catch (IOException ex) {

            throw new RuntimeException(
                    "Unable to generate README.md",
                    ex);

        }

        log.info(
                "Generated {}",
                readmePath);

    }

}