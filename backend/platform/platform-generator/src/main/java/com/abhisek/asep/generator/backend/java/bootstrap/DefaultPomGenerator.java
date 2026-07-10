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
public class DefaultPomGenerator implements PomGenerator {

    private final TemplateRepository templateRepository;

    private final TemplateEngine templateEngine;

    private final SourceWriter sourceWriter;

    @Override
    public void generate(CompilerResult compilerResult, GenerationContext generationContext) {

        Template template = templateRepository.load("pom.xml.tpl");

        TemplateContext context = new TemplateContext().put("groupId", "com.abhisek.generated").put("artifactId", "generated-service").put("version", "1.0.0-SNAPSHOT");

        String source = templateEngine.render(template, context);

        Path pomPath = generationContext.getProjectRoot().resolve("pom.xml");

        try {

            sourceWriter.write(pomPath, source);

        } catch (IOException ex) {

            throw new RuntimeException("Unable to generate pom.xml", ex);

        }

        log.info("Generated {}", pomPath);

    }

}