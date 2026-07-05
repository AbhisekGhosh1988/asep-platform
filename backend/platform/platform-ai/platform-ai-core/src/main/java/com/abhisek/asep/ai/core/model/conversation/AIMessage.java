package com.abhisek.asep.ai.core.model.conversation;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AIMessage {

    private AIMessageRole role;

    private String content;

}