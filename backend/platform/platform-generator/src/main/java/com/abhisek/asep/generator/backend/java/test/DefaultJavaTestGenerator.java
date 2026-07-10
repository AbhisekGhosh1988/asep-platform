package com.abhisek.asep.generator.backend.java.test;

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
import com.abhisek.asep.generator.ir.model.EntityIR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Slf4j
@Component
public class DefaultJavaTestGenerator extends AbstractJavaArtifactGenerator implements JavaTestGenerator {

    public DefaultJavaTestGenerator(TemplateRepository templateRepository, TemplateEngine templateEngine, SourceWriter sourceWriter) {

        super(templateRepository, templateEngine, sourceWriter);

    }

    @Override
    public ArtifactType getArtifactType() {

        return ArtifactType.UNIT_TEST;

    }

    @Override
    public void generate(GenerationTask step, CompilerResult compilerResult, GenerationContext generationContext) {

        if (!(step.getNode() instanceof EntityIR entity)) {
            return;
        }

        Template template = loadTemplate("entity-test.java.tpl");

        TemplateContext context = new TemplateContext().put("package", generationContext.getBasePackage() + ".test").put("className", entity.getName());

        String source = render(template, context);

        writeSource(resolveJavaTestFile(generationContext, generationContext.getBasePackage() + ".test", entity.getName() + "Test"), source);

        log.info("Generated Unit Test {}", entity.getName());

    }

    protected Path resolveJavaTestFile(GenerationContext context, String packageName, String className) {

        return context.resolveJavaTestFile(packageName, className);

    }

}