package com.abhisek.asep.generator.backend.java.config;

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
public class DefaultJavaConfigurationGenerator extends AbstractJavaArtifactGenerator implements JavaConfigurationGenerator {

    public DefaultJavaConfigurationGenerator(TemplateRepository templateRepository, TemplateEngine templateEngine, SourceWriter sourceWriter) {

        super(templateRepository, templateEngine, sourceWriter);

    }

    @Override
    public ArtifactType getArtifactType() {

        return ArtifactType.CONFIGURATION;

    }

    @Override
    public void generate(GenerationTask step, CompilerResult compilerResult, GenerationContext generationContext) {

        generateConfiguration(generationContext);

        log.info("Generated Configuration");

    }

    private void generateConfiguration(GenerationContext generationContext) {

        generateFile(generationContext, "jackson-config.java.tpl", "JacksonConfig");

        generateFile(generationContext, "openapi-config.java.tpl", "OpenApiConfig");

        generateFile(generationContext, "async-config.java.tpl", "AsyncConfig");

        generateFile(generationContext, "modelmapper-config.java.tpl", "ModelMapperConfig");

        generateFile(generationContext, "clock-config.java.tpl", "ClockConfig");

        generateFile(generationContext, "cors-config.java.tpl", "CorsConfig");

    }

    private void generateFile(GenerationContext generationContext, String templateName, String className) {

        String packageName = generationContext.getBasePackage() + ".config";

        Template template = loadTemplate(templateName);

        TemplateContext context = new TemplateContext().put("package", packageName);

        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, packageName, className), source);

    }

}