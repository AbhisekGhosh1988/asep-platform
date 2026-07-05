package com.abhisek.asep.requirements.application.graph.analysis;

import com.abhisek.asep.requirements.application.graph.model.Graph;
import com.abhisek.asep.requirements.application.graph.model.GraphEdge;
import com.abhisek.asep.requirements.application.graph.model.GraphNode;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BreadthFirstPathFinder implements PathFinder {

    @Override
    public List<GraphNode> shortestPath(Graph graph, GraphNode source, GraphNode target) {

        Queue<GraphNode> queue = new LinkedList<>();
        Map<GraphNode, GraphNode> previous = new HashMap<>();
        Set<GraphNode> visited = new HashSet<>();

        queue.offer(source);
        visited.add(source);

        while (!queue.isEmpty()) {

            GraphNode current = queue.poll();

            if (same(current, target)) {
                break;
            }

            for (GraphEdge edge : graph.getEdges()) {

                if (same(edge.getSource(), current) && !visited.contains(edge.getTarget())) {

                    visited.add(edge.getTarget());
                    previous.put(edge.getTarget(), current);
                    queue.offer(edge.getTarget());

                }

            }

        }

        List<GraphNode> path = new ArrayList<>();

        GraphNode current = target;

        while (current != null) {

            path.add(0, current);
            current = previous.get(current);

        }

        return path;

    }

    private boolean same(GraphNode first, GraphNode second) {

        return first.getId().equals(second.getId()) && first.getType().equals(second.getType());

    }

}