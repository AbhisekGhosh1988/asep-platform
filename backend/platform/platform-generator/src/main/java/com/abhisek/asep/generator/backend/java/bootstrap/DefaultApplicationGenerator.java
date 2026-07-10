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
public class DefaultApplicationGenerator implements ApplicationGenerator {

    private final TemplateRepository templateRepository;

    private final TemplateEngine templateEngine;

    private final SourceWriter sourceWriter;

    @Override
    public void generate(CompilerResult compilerResult, GenerationContext generationContext) {

        String basePackage = generationContext.getBasePackage();

        String applicationClass = "GeneratedServiceApplication";

        Template template = templateRepository.load("application.java.tpl");

        TemplateContext context = new TemplateContext().put("package", basePackage).put("applicationClass", applicationClass);

        String source = templateEngine.render(template, context);

        Path applicationPath = generationContext.getJavaSourceRoot().resolve(basePackage.replace('.', '/')).resolve(applicationClass + ".java");

        try {

            sourceWriter.write(applicationPath, source);

        } catch (IOException ex) {

            throw new RuntimeException("Unable to generate Spring Boot application.", ex);

        }

        log.info("Generated {}", applicationPath);

    }

}