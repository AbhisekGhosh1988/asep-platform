package com.abhisek.asep.generator.backend.java.usecase;

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
import com.abhisek.asep.generator.ir.model.UseCaseIR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultJavaUseCaseGenerator extends AbstractJavaArtifactGenerator implements JavaUseCaseGenerator {

    public DefaultJavaUseCaseGenerator(TemplateRepository templateRepository, TemplateEngine templateEngine, SourceWriter sourceWriter) {

        super(templateRepository, templateEngine, sourceWriter);

    }

    @Override
    public ArtifactType getArtifactType() {

        return ArtifactType.USE_CASE;

    }

    @Override
    public void generate(GenerationTask step, CompilerResult compilerResult, GenerationContext generationContext) {

        if (!(step.getNode() instanceof UseCaseIR useCase)) {
            return;
        }

        generateInterface(useCase, generationContext);

        generateImplementation(useCase, generationContext);

        log.info("Generated UseCase {}", useCase.getName());

    }

    private void generateInterface(UseCaseIR useCase, GenerationContext generationContext) {

        Template template = loadTemplate("usecase.java.tpl");

        TemplateContext context = new TemplateContext().put("package", generationContext.getBasePackage() + ".application.usecase").put("className", useCase.getName()).put("requestType", useCase.getRequestDto()).put("responseType", useCase.getResponseDto());

        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, generationContext.getBasePackage() + ".application.usecase", useCase.getName()), source);

    }

    private void generateImplementation(UseCaseIR useCase, GenerationContext generationContext) {

        Template template = loadTemplate("templates/usecase-impl.java.tpl");

        TemplateContext context = new TemplateContext().put("package", generationContext.getBasePackage() + ".application.usecase.impl").put("className", useCase.getName() + "Impl").put("interfaceName", useCase.getName()).put("requestType", useCase.getRequestDto()).put("responseType", useCase.getResponseDto());

        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, generationContext.getBasePackage() + ".application.usecase.impl", useCase.getName() + "Impl"), source);

    }

}