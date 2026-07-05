package com.abhisek.asep.ai.parser.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParserConfiguration {

    @Bean
    ObjectMapper objectMapper() {

        return new ObjectMapper();

    }

}