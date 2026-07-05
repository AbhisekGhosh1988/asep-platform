package com.abhisek.asep.ai.core.registry;

import com.abhisek.asep.ai.core.client.AIProvider;
import com.abhisek.asep.ai.core.config.AIModel;
import com.abhisek.asep.ai.core.exception.AIException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AIProviderRegistryImpl implements AIProviderRegistry {

    private final List<AIProvider> providers;

    @Override
    public AIProvider getProvider() {

        return providers.stream()

                .filter(AIProvider::isAvailable)

                .findFirst()

                .orElseThrow(() -> new AIException("No AI Provider available"));

    }

    @Override
    public AIProvider getProvider(AIModel model) {

        return providers.stream()

                .filter(AIProvider::isAvailable)

                .filter(provider -> provider.getSupportedModels().contains(model))

                .findFirst()

                .orElseThrow(() -> new AIException("No provider found for model " + model));

    }

}