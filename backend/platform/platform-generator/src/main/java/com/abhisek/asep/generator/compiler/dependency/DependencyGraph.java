package com.abhisek.asep.generator.compiler.dependency;

import com.abhisek.asep.generator.ir.model.BaseIRNode;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class DependencyGraph {

    private final Map<String, BaseIRNode> nodes = new LinkedHashMap<>();

    private final Map<String, Set<String>> graph = new LinkedHashMap<>();

    public void addNode(BaseIRNode node) {

        nodes.put(node.getName(), node);

        graph.computeIfAbsent(node.getName(), key -> new LinkedHashSet<>());

    }

    public void addDependency(String source, String target) {

        graph.computeIfAbsent(source, key -> new LinkedHashSet<>()).add(target);

    }

    public BaseIRNode getNode(String name) {

        return nodes.get(name);

    }

    public Collection<BaseIRNode> getNodes() {

        return Collections.unmodifiableCollection(nodes.values());

    }

    public Set<String> dependencies(String node) {

        return graph.getOrDefault(node, Collections.emptySet());

    }

}