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

        return ArtifactType.TEST;

    }

    @Override
    public void generate(GenerationTask step, CompilerResult compilerResult, GenerationContext generationContext) {

        generateBaseIntegrationTest(generationContext);

        generateAbstractControllerTest(generationContext);

        generateAbstractServiceTest(generationContext);

        generateAbstractRepositoryTest(generationContext);

        generateTestDataFactory(generationContext);

        log.info("Generated Test Infrastructure");

    }

    private void generateBaseIntegrationTest(GenerationContext generationContext) {

        generateFile(generationContext, "base-integration-test.java.tpl", "BaseIntegrationTest");

    }

    private void generateAbstractControllerTest(GenerationContext generationContext) {

        generateFile(generationContext, "abstract-controller-test.java.tpl", "AbstractControllerTest");

    }

    private void generateAbstractServiceTest(GenerationContext generationContext) {

        generateFile(generationContext, "abstract-service-test.java.tpl", "AbstractServiceTest");

    }

    private void generateAbstractRepositoryTest(GenerationContext generationContext) {

        generateFile(generationContext, "abstract-repository-test.java.tpl", "AbstractRepositoryTest");

    }

    private void generateTestDataFactory(GenerationContext generationContext) {

        generateFile(generationContext, "test-data-factory.java.tpl", "TestDataFactory");

    }

    private void generateFile(GenerationContext generationContext, String templateName, String className) {

        String packageName = generationContext.getBasePackage() + ".test";

        Template template = loadTemplate(templateName);

        TemplateContext context = new TemplateContext().put("package", packageName);

        String source = render(template, context);

        writeSource(resolveJavaTestFile(generationContext, packageName, className), source);

    }


}