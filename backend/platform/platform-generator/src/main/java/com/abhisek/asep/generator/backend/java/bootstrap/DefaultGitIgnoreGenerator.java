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
public class DefaultGitIgnoreGenerator
        implements GitIgnoreGenerator {

    private final TemplateRepository templateRepository;

    private final TemplateEngine templateEngine;

    private final SourceWriter sourceWriter;

    @Override
    public void generate(
            CompilerResult compilerResult,
            GenerationContext generationContext) {

        Template template =
                templateRepository.load(
                        "gitignore.tpl");

        TemplateContext context =
                new TemplateContext();

        String source =
                templateEngine.render(
                        template,
                        context);

        Path gitIgnorePath =
                generationContext.getProjectRoot()
                        .resolve(".gitignore");

        try {

            sourceWriter.write(
                    gitIgnorePath,
                    source);

        } catch (IOException ex) {

            throw new RuntimeException(
                    "Unable to generate .gitignore",
                    ex);

        }

        log.info(
                "Generated {}",
                gitIgnorePath);

    }

}