package com.abhisek.asep.generator.backend.java.entity.template;

import com.abhisek.asep.generator.ir.model.AttributeIR;
import com.abhisek.asep.generator.ir.model.EntityIR;
import org.springframework.stereotype.Component;

@Component
public class DefaultEntityTemplateProvider
        implements EntityTemplateProvider {

    @Override
    public String generate(EntityIR entity) {

        StringBuilder builder = new StringBuilder();

        builder.append("""
                package generated.entity;

                import jakarta.persistence.*;
                import lombok.*;

                @Getter
                @Setter
                @Entity
                @NoArgsConstructor
                @AllArgsConstructor
                @Builder
                """);

        builder.append("\n");

        builder.append("public class ")
                .append(entity.getName())
                .append(" {\n\n");

        builder.append("""
                    @Id
                    @GeneratedValue(strategy = GenerationType.IDENTITY)
                    private Long id;

                """);

        for (AttributeIR attribute : entity.getAttributes()) {

            builder.append("    private ")
                    .append(attribute.getDataType())
                    .append(" ")
                    .append(attribute.getName())
                    .append(";\n");

        }

        builder.append("}");

        return builder.toString();

    }

}