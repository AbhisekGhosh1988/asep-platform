package com.abhisek.asep.generator.backend.java.bootstrap;

import com.abhisek.asep.generator.backend.context.GenerationContext;
import com.abhisek.asep.generator.backend.template.Template;
import com.abhisek.asep.generator.backend.template.TemplateContext;
import com.abhisek.asep.generator.backend.template.TemplateEngine;
import com.abhisek.asep.generator.backend.template.TemplateRepository;
import com.abhisek.asep.generator.backend.writer.SourceWriter;
import com.abhisek.asep.generator.compiler.pipeline.CompilerResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;

@Component
@RequiredArgsConstructor
public class DefaultApplicationYamlGenerator implements ApplicationYamlGenerator {

    private final TemplateRepository templateRepository;

    private final TemplateEngine templateEngine;

    private final SourceWriter sourceWriter;

    @Override
    public void generate(CompilerResult compilerResult, GenerationContext generationContext) {

        Template template = templateRepository.load("application.yml.tpl");

        String source = templateEngine.render(template, new TemplateContext().put("applicationName", "generated-service"));

        Path file = generationContext.getResourceRoot().resolve("application.yml");

        try {

            sourceWriter.write(file, source);

        } catch (IOException ex) {

            throw new RuntimeException(ex);

        }

    }

}