package com.abhisek.asep.requirements.application.graph.analysis;

import com.abhisek.asep.requirements.application.graph.model.Graph;
import com.abhisek.asep.requirements.application.graph.model.GraphEdge;
import com.abhisek.asep.requirements.application.graph.model.GraphNode;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DefaultCycleDetector implements CycleDetector {

    @Override
    public boolean hasCycle(Graph graph) {

        Set<GraphNode> visited = new HashSet<>();
        Set<GraphNode> recursionStack = new HashSet<>();

        for (GraphNode node : graph.getNodes()) {

            if (detect(graph, node, visited, recursionStack)) {

                return true;

            }

        }

        return false;

    }

    private boolean detect(Graph graph, GraphNode current, Set<GraphNode> visited, Set<GraphNode> recursionStack) {

        if (recursionStack.contains(current)) {
            return true;
        }

        if (visited.contains(current)) {
            return false;
        }

        visited.add(current);
        recursionStack.add(current);

        for (GraphEdge edge : graph.getEdges()) {

            if (same(edge.getSource(), current)) {

                if (detect(graph, edge.getTarget(), visited, recursionStack)) {

                    return true;

                }

            }

        }

        recursionStack.remove(current);

        return false;

    }

    private boolean same(GraphNode first, GraphNode second) {

        return first.getId().equals(second.getId()) && first.getType().equals(second.getType());

    }

}