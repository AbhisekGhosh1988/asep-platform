package com.abhisek.asep.generator.backend.java.specification;

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
import com.abhisek.asep.generator.ir.model.SpecificationIR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultJavaSpecificationGenerator extends AbstractJavaArtifactGenerator implements JavaSpecificationGenerator {

    public DefaultJavaSpecificationGenerator(TemplateRepository templateRepository, TemplateEngine templateEngine, SourceWriter sourceWriter) {

        super(templateRepository, templateEngine, sourceWriter);

    }

    @Override
    public ArtifactType getArtifactType() {

        return ArtifactType.SPECIFICATION;

    }

    @Override
    public void generate(GenerationTask step, CompilerResult compilerResult, GenerationContext generationContext) {

        if (!(step.getNode() instanceof SpecificationIR specification)) {

            return;

        }

        String packageName = generationContext.getBasePackage() + ".domain.specification";

        String entityPackage = generationContext.getBasePackage() + ".domain.entity";

        Template template = loadTemplate("specification.java.tpl");

        TemplateContext context = new TemplateContext().put("package", packageName).put("entityPackage", entityPackage).put("className", specification.getName()).put("targetEntity", specification.getTargetEntity());

        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, packageName, specification.getName()), source);

        log.info("Generated Specification {}", specification.getName());

    }

}