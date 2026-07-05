package com.abhisek.asep.requirements.application.graph.traversal;

import com.abhisek.asep.requirements.application.graph.model.Graph;
import com.abhisek.asep.requirements.application.graph.model.GraphEdge;
import com.abhisek.asep.requirements.application.graph.model.GraphNode;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BreadthFirstTraversal implements GraphTraversal {

    @Override
    public Set<GraphNode> traverse(Graph graph, GraphNode startNode) {

        Set<GraphNode> visited = new LinkedHashSet<>();

        Queue<GraphNode> queue = new LinkedList<>();

        queue.add(startNode);

        while (!queue.isEmpty()) {

            GraphNode current = queue.poll();

            if (!visited.add(current)) {
                continue;
            }

            graph.getEdges().stream().filter(edge -> same(edge.getSource(), current)).map(GraphEdge::getTarget).filter(node -> !visited.contains(node)).forEach(queue::offer);

        }

        return visited;

    }

    private boolean same(GraphNode first, GraphNode second) {

        return first.getId().equals(second.getId()) && first.getType().equals(second.getType());

    }

}