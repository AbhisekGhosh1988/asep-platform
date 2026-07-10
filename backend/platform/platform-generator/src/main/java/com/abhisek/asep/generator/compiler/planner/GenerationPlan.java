package com.abhisek.asep.generator.compiler.planner;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Ordered generation plan.
 */
@Getter
public class GenerationPlan {

    private final List<GenerationTask> tasks =
            new ArrayList<>();

    public void addTask(GenerationTask step) {

        tasks.add(step);

    }

    public List<GenerationTask> getTasks() {

        return Collections.unmodifiableList(tasks);

    }

}