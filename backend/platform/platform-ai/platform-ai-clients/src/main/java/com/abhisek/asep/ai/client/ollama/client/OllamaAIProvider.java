package com.abhisek.asep.ai.client.ollama.client;

import com.abhisek.asep.ai.core.client.AIProvider;
import com.abhisek.asep.ai.core.config.AIModel;
import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class OllamaAIProvider implements AIProvider {

    private final ChatClient chatClient;

    @Override
    public String getProviderName() {
        return "OLLAMA";
    }

    @Override
    public boolean isAvailable() {
        // Later we'll implement a health check against Ollama.
        return true;
    }

    @Override
    public Set<AIModel> getSupportedModels() {
        return Set.of(
                AIModel.LLAMA3_1,
                AIModel.MISTRAL,
                AIModel.GEMMA,
                AIModel.QWEN,
                AIModel.DEEPSEEK,
                AIModel.PHI4);
    }

    @Override
    public AIResponse generate(AIRequest request) {

        String content = chatClient.prompt()
                .system(request.getSystemPrompt())
                .user(request.getUserPrompt())
                .call()
                .content();

        return AIResponse.builder()
                .provider(getProviderName())
                .model(request.getModel().name()) // Fixed: changed getModel() to request.getModel()
                .content(content)
                .build();
    }
}