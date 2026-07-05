package com.abhisek.asep.ai.prompt.template;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromptTemplate {

    private String systemPrompt;

    private String userPrompt;

}