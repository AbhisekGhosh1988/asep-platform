package com.abhisek.asep.generator.backend.java.valueobject;

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
import com.abhisek.asep.generator.ir.model.ValueObjectIR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultJavaValueObjectGenerator extends AbstractJavaArtifactGenerator implements JavaValueObjectGenerator {

    public DefaultJavaValueObjectGenerator(TemplateRepository templateRepository, TemplateEngine templateEngine, SourceWriter sourceWriter) {

        super(templateRepository, templateEngine, sourceWriter);

    }

    @Override
    public ArtifactType getArtifactType() {

        return ArtifactType.VALUE_OBJECT;

    }

    @Override
    public void generate(GenerationTask step, CompilerResult compilerResult, GenerationContext generationContext) {

        if (!(step.getNode() instanceof ValueObjectIR valueObject)) {

            return;

        }

        Template template = loadTemplate("value-object.java.tpl");

        TemplateContext context = new TemplateContext().put("package", generationContext.getBasePackage() + ".domain.valueobject");
        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, generationContext.getBasePackage() + ".domain.valueobject", valueObject.getName()), source);

        log.info("Generated ValueObject {}", valueObject.getName());

    }

    private String buildFields(ValueObjectIR valueObject) {

        StringBuilder builder = new StringBuilder();

        for (AttributeIR attribute : valueObject.getAttributes()) {

            builder.append("    /**\n")
                    .append("     * ")
                    .append(attribute.getDescription() == null
                            ? attribute.getName()
                            : attribute.getDescription())
                    .append("\n")
                    .append("     */\n")
                    .append("    private ")
                    .append(attribute.getDataType())
                    .append(" ")
                    .append(attribute.getName())
                    .append(";\n\n");

        }

        return builder.toString();

    }

}