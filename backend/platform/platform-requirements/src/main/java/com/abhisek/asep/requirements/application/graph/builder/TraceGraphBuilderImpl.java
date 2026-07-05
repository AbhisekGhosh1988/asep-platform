package com.abhisek.asep.requirements.application.graph.builder;

import com.abhisek.asep.requirements.application.graph.model.Graph;
import com.abhisek.asep.requirements.application.graph.model.GraphEdge;
import com.abhisek.asep.requirements.application.graph.model.GraphNode;
import com.abhisek.asep.requirements.application.service.TraceLinkService;
import com.abhisek.asep.requirements.domain.enums.TraceEntityType;
import com.abhisek.asep.requirements.domain.model.TraceLink;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TraceGraphBuilderImpl implements TraceGraphBuilder {

    private final TraceLinkService traceLinkService;

    @Override
    public Graph buildGraph(TraceEntityType entityType, String entityId) {

        Graph graph = new Graph();

        GraphNode root = GraphNode.builder().id(entityId).type(entityType.name()).build();

        graph.addNode(root);

        for (TraceLink link : traceLinkService.allLinks(entityType, entityId)) {

            GraphNode target = GraphNode.builder().id(link.getTargetId()).type(link.getTargetType().name()).build();

            graph.addNode(target);

            graph.addEdge(GraphEdge.builder().source(root).target(target).relation(link.getRelationType().name()).build());

        }

        return graph;

    }

}