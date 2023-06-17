package common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GraphForTopologicalSort<T> extends Graph<T> {

    Map<T, Integer> incoming = new HashMap<>();

    @Override
    public void addEdge(T v1, T v2) {
        super.addEdge(v1, v2);
        incrementIncoming(v2);
    }

    @Override
    public void addVertex(T v) {
        super.addVertex(v);
        incoming.put(v, 0);
    }

    public void incrementIncoming(T v1) {
        incoming.compute(v1, (k, v) -> v == null ? 1 : v+1);
    }

    public void decrementIncoming(T v1) {
        incoming.compute(v1, (k, v) -> v == null ? null : v-1);
    }

    public List<T> verticesWithZeroIncoming() {
        return incoming.keySet()
                .stream()
                .filter(k -> incoming.get(k) == 0)
                .collect(Collectors.toList());
    }

    public int getIncomingForVertex(T v1) {
        return incoming.getOrDefault(v1, 0);
    }
}
