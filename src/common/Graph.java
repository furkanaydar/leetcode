package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {
    private final Map<T, List<T>> adjacency = new HashMap<>();

    public Map<T, List<T>> getAdjacency() {
        return adjacency;
    }

    public void addVertex(T v) {
        adjacency.put(v, new ArrayList<>());
    }

    public void addEdge(T v1, T v2) {
        if (!adjacency.containsKey(v1) || !adjacency.containsKey(v2)) {
            return;
        }

        adjacency.get(v1).add(v2);
    }

    public void addEdgeBidirectional(T v1, T v2) {
        addEdge(v1, v2);
        addEdge(v2, v1);
    }

    public List<T> getNeighbors(T v1) {
        return adjacency.getOrDefault(v1, List.of());
    }

    public List<T> getAllVertices() {
        return new ArrayList<>(adjacency.keySet());
    }

    public void removeVertex(T v) {
        adjacency.remove(v);
        for (List<T> values: adjacency.values()) {
            values.remove(v);
        }
    }
}
