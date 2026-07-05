package com.abhisek.asep.ai.core.registry;

import com.abhisek.asep.ai.core.client.AIProvider;
import com.abhisek.asep.ai.core.config.AIModel;

public interface AIProviderRegistry {

    AIProvider getProvider();

    AIProvider getProvider(AIModel model);

}