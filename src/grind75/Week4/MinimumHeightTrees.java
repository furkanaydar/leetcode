package grind75.Week4;

import java.util.*;

public class MinimumHeightTrees {

    class Graph {
        Map<Integer, Set<Integer>> adj;
        int[] incoming;

        public Graph(int n) {
            adj = new HashMap<>();
            for (int i=0; i<n; i++) {
                adj.put(i, new HashSet<>());
            }
            incoming = new int[n];
        }

        void addEdge(int i, int j) {
            adj.get(i).add(j);
            adj.get(j).add(i);
            incoming[i]++;
            incoming[j]++;
        }

        public List<Integer> oneIncoming() {
            List<Integer> res = new ArrayList<>();
            for (int i=0; i<incoming.length; i++) {
                if (incoming[i] == 1) {
                    res.add(i);
                }
            }

            return res;
        }
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n==1) {
            return List.of(0);
        }

        Graph g = new Graph(n);
        for (int[] i: edges) {
            g.addEdge(i[0], i[1]);
        }

        Queue<Integer> q = new LinkedList<>(g.oneIncoming());
        int c = n;
        while (!q.isEmpty()) {
            List<Integer> next = new ArrayList<>();
            if (c == 1 || c == 2) {
                return new ArrayList<>(q);
            }
            while (!q.isEmpty()) {
                Integer cur = q.poll();
                c--;
                for (int ne: g.adj.get(cur)) {
                    g.incoming[ne]--;
                    g.incoming[cur]--;
                    if (g.incoming[ne] == 1) {
                        next.add(ne);
                    }
                }
            }
            q.addAll(next);
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        MinimumHeightTrees mht = new MinimumHeightTrees();
        List<Integer> l = mht.findMinHeightTrees(6, new int[][] {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}});
        List<Integer> l2 = mht.findMinHeightTrees(4, new int[][] {{1, 0}, {1, 2}, {1, 3}});
        List<Integer> l3 = mht.findMinHeightTrees(3, new int[][] {{0, 1}, {0, 2}});

        int x = 5;
    }
}
