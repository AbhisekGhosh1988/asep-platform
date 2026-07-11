package com.abhisek.asep.generator.backend.java.exception;

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

@Slf4j
@Component
public class DefaultJavaExceptionHandlerGenerator extends AbstractJavaArtifactGenerator implements JavaExceptionHandlerGenerator {

    public DefaultJavaExceptionHandlerGenerator(TemplateRepository templateRepository, TemplateEngine templateEngine, SourceWriter sourceWriter) {

        super(templateRepository, templateEngine, sourceWriter);

    }

    @Override
    public ArtifactType getArtifactType() {

        return ArtifactType.EXCEPTION_HANDLER;

    }

    @Override
    public void generate(GenerationTask step, CompilerResult compilerResult, GenerationContext generationContext) {

        generateGlobalExceptionHandler(generationContext);

        generateApiErrorResponse(generationContext);

        generateValidationErrorResponse(generationContext);

        generateBusinessException(generationContext);

        generateResourceNotFoundException(generationContext);

        log.info("Generated Exception Framework");

    }

    private void generateGlobalExceptionHandler(GenerationContext generationContext) {

        String packageName = generationContext.getBasePackage() + ".interfaces.rest.exception";

        Template template = loadTemplate("global-exception-handler.java.tpl");

        TemplateContext context = new TemplateContext().put("package", packageName);

        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, packageName, "GlobalExceptionHandler"), source);

    }

    private void generateApiErrorResponse(GenerationContext generationContext) {

        String packageName = generationContext.getBasePackage() + ".interfaces.rest.exception";

        Template template = loadTemplate("api-error-response.java.tpl");

        TemplateContext context = new TemplateContext().put("package", packageName);

        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, packageName, "ApiErrorResponse"), source);

    }

    private void generateValidationErrorResponse(GenerationContext generationContext) {

        String packageName = generationContext.getBasePackage() + ".interfaces.rest.exception";

        Template template = loadTemplate("validation-error-response.java.tpl");

        TemplateContext context = new TemplateContext().put("package", packageName);

        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, packageName, "ValidationErrorResponse"), source);

    }

    private void generateBusinessException(GenerationContext generationContext) {

        String packageName = generationContext.getBasePackage() + ".interfaces.rest.exception";

        Template template = loadTemplate("business-exception.java.tpl");

        TemplateContext context = new TemplateContext().put("package", packageName);

        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, packageName, "BusinessException"), source);

    }

    private void generateResourceNotFoundException(GenerationContext generationContext) {

        String packageName = generationContext.getBasePackage() + ".interfaces.rest.exception";

        Template template = loadTemplate("resource-not-found-exception.java.tpl");

        TemplateContext context = new TemplateContext().put("package", packageName);

        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, packageName, "ResourceNotFoundException"), source);

    }

}