package com.abhisek.asep.ai.core.model.conversation;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AIConversation {

    @Builder.Default
    private List<AIMessage> messages = new ArrayList<>();

    public void addSystemMessage(String message) {

        messages.add(

                AIMessage.builder().role(AIMessageRole.SYSTEM).content(message).build());

    }

    public void addUserMessage(String message) {

        messages.add(

                AIMessage.builder().role(AIMessageRole.USER).content(message).build());

    }

    public void addAssistantMessage(String message) {

        messages.add(

                AIMessage.builder().role(AIMessageRole.ASSISTANT).content(message).build());

    }

}