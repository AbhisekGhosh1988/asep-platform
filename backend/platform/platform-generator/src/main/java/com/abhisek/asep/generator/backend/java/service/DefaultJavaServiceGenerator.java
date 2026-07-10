package com.abhisek.asep.generator.backend.java.service;

import com.abhisek.asep.generator.backend.context.GenerationContext;
import com.abhisek.asep.generator.backend.java.support.AbstractJavaArtifactGenerator;
import com.abhisek.asep.generator.backend.spi.ArtifactType;
import com.abhisek.asep.generator.backend.template.TemplateEngine;
import com.abhisek.asep.generator.backend.template.TemplateRepository;
import com.abhisek.asep.generator.backend.writer.SourceWriter;
import com.abhisek.asep.generator.compiler.pipeline.CompilerResult;
import com.abhisek.asep.generator.compiler.planner.GenerationTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultJavaServiceGenerator extends AbstractJavaArtifactGenerator implements JavaServiceGenerator {

    public DefaultJavaServiceGenerator(TemplateRepository templateRepository, TemplateEngine templateEngine, SourceWriter sourceWriter) {

        super(templateRepository, templateEngine, sourceWriter);

    }

    @Override
    public ArtifactType getArtifactType() {

        return ArtifactType.SERVICE;

    }

    @Override
    public void generate(GenerationTask step, CompilerResult compilerResult, GenerationContext generationContext) {

        /*
         * Full implementation comes in the
         * Service Generator sprint.
         */

        log.info("Skipping Service generation for {}", step.getName());

    }

}