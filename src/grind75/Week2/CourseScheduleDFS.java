package grind75.Week2;

import common.Graph;

import java.util.HashSet;
import java.util.Set;

public class CourseScheduleDFS {


    static boolean dfs(Graph<Integer> graph, int n, Set<Integer> mainVisited, Set<Integer> currentVisited) {
        mainVisited.add(n);
        currentVisited.add(n);

        for (Integer neighbor: graph.getNeighbors(n)) {
            if (!mainVisited.contains(neighbor)) {
                if (dfs(graph, neighbor, mainVisited, currentVisited)) {
                    return true;
                }
            } else if (currentVisited.contains(neighbor)) {
                return true;
            }
        }

        currentVisited.remove(n);
        return false;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph<Integer> graph = new Graph<>();
        Set<Integer> mainVisited = new HashSet<>();

        for (int i=0; i<numCourses; i++) {
            graph.addVertex(i);
        }

        for (int i=0; i<prerequisites.length; i++) {
            graph.addEdge(prerequisites[i][1], prerequisites[i][0]);
        }

        for (int i=0; i<numCourses; i++) {
            if (!mainVisited.contains(i) && dfs(graph, i, mainVisited, new HashSet<>())) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(5, new int[][] {{1,4},{2,4},{3,1},{3,2}}));
        //System.out.println(canFinish(2, new int[][] {{1,0}}));

    }
}
