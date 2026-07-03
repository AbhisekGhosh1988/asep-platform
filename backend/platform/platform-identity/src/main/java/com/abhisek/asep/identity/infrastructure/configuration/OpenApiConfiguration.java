package com.abhisek.asep.identity.infrastructure.configuration;

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
    public OpenAPI identityApi() {

        final String scheme = "Bearer Authentication";

        return new OpenAPI()

                .info(new Info()

                        .title("ASEP Identity API")

                        .description("Authentication & Authorization APIs")

                        .version("1.0.0")

                        .contact(new Contact()
                                .name("ASEP")
                                .email("admin@asep.ai"))

                        .license(new License()
                                .name("Proprietary")))

                .addSecurityItem(
                        new SecurityRequirement()
                                .addList(scheme))

                .schemaRequirement(
                        scheme,

                        new SecurityScheme()

                                .type(SecurityScheme.Type.HTTP)

                                .scheme("bearer")

                                .bearerFormat("JWT"));
    }
}