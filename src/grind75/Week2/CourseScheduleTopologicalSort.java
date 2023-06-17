package grind75.Week2;


import common.GraphForTopologicalSort;

import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleTopologicalSort {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        GraphForTopologicalSort<Integer> graph = new GraphForTopologicalSort<>();

        for (int i=0; i<numCourses; i++) {
            graph.addVertex(i);
        }

        for (int i=0; i<prerequisites.length; i++) {
            graph.addEdge(prerequisites[i][1], prerequisites[i][0]);
        }

        Queue<Integer> q = new LinkedList<>(graph.verticesWithZeroIncoming());
        int obtained=0;

        while (!q.isEmpty()) {
            Integer polled = q.poll();
            obtained++;
            for (Integer n: graph.getNeighbors(polled)) {
                graph.decrementIncoming(n);
                if (graph.getIncomingForVertex(n) == 0) {
                    q.add(n);
                }
            }
        }

        return obtained == numCourses;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(5, new int[][] {{1,4}, {3,1}, {2, 3}, {2, 4}}));
        //System.out.println(canFinish(2, new int[][] {{1,0}, {0,1}}));
        //System.out.println(canFinish(4, new int[][] {{1,0}, {2,1}, {3, 2}, {1, 3}}));

    }
}
