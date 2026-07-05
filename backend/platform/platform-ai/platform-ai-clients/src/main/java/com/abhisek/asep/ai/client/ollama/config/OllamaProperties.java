package com.abhisek.asep.ai.client.ollama.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "asep.ai.ollama")
public class OllamaProperties {

    /**
     * Example:
     * http://localhost:11434
     */
    private String baseUrl = "http://localhost:11434";

    /**
     * Default model.
     */
    private String model = "llama3.1";

    /**
     * Temperature.
     */
    private Double temperature = 0.2;

}