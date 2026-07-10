package com.abhisek.asep.generator.compiler.planner;

import com.abhisek.asep.generator.compiler.dependency.DependencyGraph;

public interface GenerationPlanner {

    GenerationPlan createPlan(
            DependencyGraph dependencyGraph);

}