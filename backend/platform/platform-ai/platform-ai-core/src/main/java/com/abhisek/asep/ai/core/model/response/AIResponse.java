package com.abhisek.asep.ai.core.model.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AIResponse {

    /**
     * AI response.
     */
    private String content;

    /**
     * Model used.
     */
    private String model;

    /**
     * Provider.
     */
    private String provider;

    /**
     * Prompt tokens.
     */
    private Integer promptTokens;

    /**
     * Completion tokens.
     */
    private Integer completionTokens;

    /**
     * Total tokens.
     */
    private Integer totalTokens;

    /**
     * Response time.
     */
    private Long responseTimeMillis;

}