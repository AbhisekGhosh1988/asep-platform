package com.abhisek.asep.ai.core.service;

import com.abhisek.asep.ai.core.client.AIProvider;
import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.registry.AIProviderRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultAIService
        implements AIService {

    private final AIProviderRegistry registry;

    @Override
    public AIResponse generate(
            AIRequest request) {

        AIProvider provider =
                registry.getProvider(
                        request.getModel());

        return provider.generate(request);

    }

}