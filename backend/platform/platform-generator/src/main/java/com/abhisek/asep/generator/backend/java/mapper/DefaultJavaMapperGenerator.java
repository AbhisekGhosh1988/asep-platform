package com.abhisek.asep.generator.backend.java.mapper;

import com.abhisek.asep.generator.backend.context.GenerationContext;
import com.abhisek.asep.generator.backend.java.support.AbstractJavaArtifactGenerator;
import com.abhisek.asep.generator.backend.spi.ArtifactType;
import com.abhisek.asep.generator.backend.template.Template;
import com.abhisek.asep.generator.backend.template.TemplateContext;
import com.abhisek.asep.generator.backend.template.TemplateEngine;
import com.abhisek.asep.generator.backend.template.TemplateRepository;
import com.abhisek.asep.generator.backend.writer.SourceWriter;
import com.abhisek.asep.generator.compiler.pipeline.CompilerResult;
import com.abhisek.asep.generator.compiler.planner.GenerationTask;
import com.abhisek.asep.generator.ir.model.MapperIR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultJavaMapperGenerator extends AbstractJavaArtifactGenerator implements JavaMapperGenerator {

    public DefaultJavaMapperGenerator(TemplateRepository templateRepository, TemplateEngine templateEngine, SourceWriter sourceWriter) {

        super(templateRepository, templateEngine, sourceWriter);

    }

    @Override
    public ArtifactType getArtifactType() {

        return ArtifactType.MAPPER;

    }

    @Override
    public void generate(GenerationTask step, CompilerResult compilerResult, GenerationContext generationContext) {

        if (!(step.getNode() instanceof MapperIR mapper)) {

            return;

        }

        Template template = loadTemplate("mapper.java.tpl");

        TemplateContext context = new TemplateContext().put("package", generationContext.getBasePackage() + ".application.mapper").put("className", mapper.getName()).put("entityClass", mapper.getEntity()).put("dtoClass", mapper.getDto());

        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, generationContext.getBasePackage() + ".application.mapper", mapper.getName()), source);

        log.info("Generated Mapper {}", mapper.getName());

    }

}