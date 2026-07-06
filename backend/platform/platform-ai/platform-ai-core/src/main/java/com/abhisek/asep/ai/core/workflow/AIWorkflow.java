package com.abhisek.asep.ai.core.workflow;

public interface AIWorkflow<I, O> {

    O execute(I input);

}