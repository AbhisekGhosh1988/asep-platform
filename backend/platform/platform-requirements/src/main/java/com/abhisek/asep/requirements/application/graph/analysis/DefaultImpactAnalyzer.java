package com.abhisek.asep.requirements.application.graph.analysis;

import com.abhisek.asep.requirements.application.graph.model.Graph;
import com.abhisek.asep.requirements.application.graph.model.GraphNode;
import com.abhisek.asep.requirements.application.graph.traversal.BreadthFirstTraversal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DefaultImpactAnalyzer
        implements ImpactAnalyzer {

    private final BreadthFirstTraversal traversal;

    @Override
    public Set<GraphNode> impactedNodes(
            Graph graph,
            GraphNode changedNode) {

        return traversal.traverse(
                graph,
                changedNode);

    }

}