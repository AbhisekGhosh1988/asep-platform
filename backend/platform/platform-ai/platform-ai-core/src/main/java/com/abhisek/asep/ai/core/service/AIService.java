package com.abhisek.asep.ai.core.service;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;

public interface AIService {

    AIResponse generate(
            AIRequest request);

}