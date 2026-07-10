package com.abhisek.asep.generator.backend.java.entity;

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
import com.abhisek.asep.generator.ir.model.EntityIR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultJavaEntityGenerator extends AbstractJavaArtifactGenerator implements JavaEntityGenerator {

    public DefaultJavaEntityGenerator(TemplateRepository templateRepository, TemplateEngine templateEngine, SourceWriter sourceWriter) {

        super(templateRepository, templateEngine, sourceWriter);

    }

    @Override
    public ArtifactType getArtifactType() {

        return ArtifactType.ENTITY;

    }

    @Override
    public void generate(GenerationTask step, CompilerResult compilerResult, GenerationContext generationContext) {

        if (!(step.getNode() instanceof EntityIR entity)) {

            return;

        }

        Template template = loadTemplate("entity.java.tpl");

        TemplateContext context = new TemplateContext().put("package", generationContext.getBasePackage() + ".entity").put("table", entity.getName().toLowerCase()).put("className", entity.getName()).put("fields", buildFields(entity));

        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, generationContext.getBasePackage() + ".entity", entity.getName()), source);

        log.info("Generated Entity {}", entity.getName());

    }

    private String buildFields(EntityIR entity) {

        StringBuilder builder = new StringBuilder();

        for (AttributeIR attribute : entity.getAttributes()) {

            if (attribute.isIdentifier()) {

                builder.append("""
                        @Id
                        @GeneratedValue(strategy = GenerationType.IDENTITY)
                        """);

            }

            builder.append("    @Column(");

            boolean first = true;

            if (!attribute.isNullable()) {

                builder.append("nullable = false");
                first = false;

            }

            if (attribute.isUnique()) {

                if (!first) {

                    builder.append(", ");

                }

                builder.append("unique = true");

            }

            builder.append(")\n");

            builder.append("    private ").append(attribute.getDataType()).append(" ").append(attribute.getName()).append(";\n\n");

        }

        return builder.toString();

    }

}