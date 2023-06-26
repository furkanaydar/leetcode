package grind75.Week3;

import java.util.*;
import java.util.stream.Collectors;

public class CourseSchedule2 {

    class TopologySortGraph {
        Map<Integer, Integer> incoming;
        Map<Integer, List<Integer>> adjacency;

        public TopologySortGraph() {
            this.incoming = new HashMap<>();
            this.adjacency = new HashMap<>();
        }

        void addNode(int index) {
            adjacency.put(index, new ArrayList<>());
            incoming.put(index, 0);
        }

        void addEdge(int f, int t) {
            if (adjacency.containsKey(f) && adjacency.containsKey(t)) {
                adjacency.get(f).add(t);
                incoming.compute(t, (k, v) -> v == null ? 1 : v+1);
            }
        }

        List<Integer> nodesWithZeroIncoming() {
            return incoming.keySet()
                    .stream()
                    .filter(k -> incoming.get(k) == 0)
                    .collect(Collectors.toList());
        }

        int decrementIncoming(int t) {
            incoming.compute(t, (k,v) -> v == null ? 0 : v-1);
            return incoming.get(t);
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        TopologySortGraph graph = new TopologySortGraph();
        for (int i=0; i<numCourses; i++) {
            graph.addNode(i);
        }

        for (int[] prerequisite : prerequisites) {
            graph.addEdge(prerequisite[1], prerequisite[0]);
        }

        Queue<Integer> q = new LinkedList<>(graph.nodesWithZeroIncoming());
        List<Integer> l = new ArrayList<>();

        while (!q.isEmpty()) {
            Integer cur = q.poll();
            l.add(cur);
            for (Integer adj: graph.adjacency.get(cur)) {
                if (graph.decrementIncoming(adj) == 0) {
                    q.add(adj);
                }
            }
        }

        return l.size() == numCourses ? l.stream().mapToInt(i -> i).toArray() : new int[] {};
    }

    public static void main(String[] args) {
        CourseSchedule2 q = new CourseSchedule2();
        q.findOrder(4, new int[][] {{1, 0}, {2, 0}, {3, 1}, {3, 2}});

    }
}
