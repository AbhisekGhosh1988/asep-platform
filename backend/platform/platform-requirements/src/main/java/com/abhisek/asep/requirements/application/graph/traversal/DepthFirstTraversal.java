package com.abhisek.asep.requirements.application.graph.traversal;

import com.abhisek.asep.requirements.application.graph.model.Graph;
import com.abhisek.asep.requirements.application.graph.model.GraphEdge;
import com.abhisek.asep.requirements.application.graph.model.GraphNode;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class DepthFirstTraversal implements GraphTraversal {

    @Override
    public Set<GraphNode> traverse(Graph graph, GraphNode startNode) {

        Set<GraphNode> visited = new LinkedHashSet<>();

        dfs(graph, startNode, visited);

        return visited;

    }

    private void dfs(Graph graph, GraphNode current, Set<GraphNode> visited) {

        if (!visited.add(current)) {
            return;
        }

        graph.getEdges().stream().filter(edge -> same(edge.getSource(), current)).map(GraphEdge::getTarget).forEach(node -> dfs(graph, node, visited));

    }

    private boolean same(GraphNode first, GraphNode second) {

        return first.getId().equals(second.getId()) && first.getType().equals(second.getType());

    }

}