package com.abhisek.asep.web.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI openAPI() {

        final String securityScheme = "bearerAuth";

        return new OpenAPI().info(new Info().title("ASEP API").description("""
                                AI Software Engineering Platform

                                Requirements → Architecture → Design → Code → Test → Review
                                """).version("1.0.0-SNAPSHOT").contact(new Contact().name("ASEP").
                email("support@asep.ai")).license(new License().name("Apache 2.0"))).
                addSecurityItem(new SecurityRequirement().addList(securityScheme)).
                components(new Components().addSecuritySchemes(securityScheme, new SecurityScheme().
                        name(securityScheme).type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
    }
}