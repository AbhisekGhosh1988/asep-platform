package com.abhisek.asep.generator.backend.java.dto;

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
import com.abhisek.asep.generator.ir.model.AttributeIR;
import com.abhisek.asep.generator.ir.model.DtoIR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultJavaDtoGenerator extends AbstractJavaArtifactGenerator implements JavaDtoGenerator {

    public DefaultJavaDtoGenerator(TemplateRepository templateRepository, TemplateEngine templateEngine, SourceWriter sourceWriter) {

        super(templateRepository, templateEngine, sourceWriter);

    }

    @Override
    public ArtifactType getArtifactType() {

        return ArtifactType.DTO;

    }

    @Override
    public void generate(GenerationTask step, CompilerResult compilerResult, GenerationContext generationContext) {

        if (!(step.getNode() instanceof DtoIR dto)) {

            return;

        }

        String packageName = switch (dto.getType()) {

            case REQUEST -> generationContext.getBasePackage() + ".application.dto.request";

            case RESPONSE -> generationContext.getBasePackage() + ".application.dto.response";

            default -> generationContext.getBasePackage() + ".application.dto";

        };

        Template template = loadTemplate("dto.java.tpl");

        TemplateContext context = new TemplateContext().put("package", packageName).put("className", dto.getName()).put("fields", buildFields(dto));

        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, packageName, dto.getName()), source);

        log.info("Generated DTO {}", dto.getName());

    }

    private String buildFields(DtoIR dto) {

        StringBuilder builder = new StringBuilder();

        for (AttributeIR attribute : dto.getAttributes()) {

            builder.append("    private ").append(attribute.getDataType()).append(" ").append(attribute.getName()).append(";\n\n");

        }

        return builder.toString();

    }

}