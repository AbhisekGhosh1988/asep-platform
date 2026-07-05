package com.abhisek.asep.ai.core.model.request;

import com.abhisek.asep.ai.core.config.AIModel;
import com.abhisek.asep.ai.core.constants.AIConstants;
import com.abhisek.asep.ai.core.model.conversation.AIConversation;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AIRequest {

    /**
     * AI model to use.
     */
    @Builder.Default
    private AIModel model = AIModel.LLAMA3_1;

    /**
     * System prompt.
     */
    private String systemPrompt;

    /**
     * User prompt.
     */
    private String userPrompt;

    /**
     * Optional conversation.
     */
    private AIConversation conversation;

    /**
     * Temperature.
     */
    @Builder.Default
    private Double temperature =
            AIConstants.DEFAULT_TEMPERATURE;

    /**
     * Maximum tokens.
     */
    @Builder.Default
    private Integer maxTokens =
            AIConstants.DEFAULT_MAX_TOKENS;

}