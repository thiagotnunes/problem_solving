package graph.examples.example_2;

import graph.types.AdjacencyList;
import graph.types.Graph;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Minimum number of edges from v to all other vertices in a graph where all edges cost 1
 */
public class Solution {
    /**
     * BFS
     * Time complexity - O(V + E)
     * Space complexity - O(V)
     */
    public int[] solve1(Graph graph, int v) {
        int vertices = graph.numberOfVertices();
        boolean[] seen = new boolean[vertices];
        int[] weights = new int[vertices];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.fill(weights, Integer.MAX_VALUE);

        weights[v] = 0;
        seen[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            int current = queue.remove();

            for (int u : graph.neighbours(current)) {
                if (!seen[u]) {
                    weights[u] = weights[current] + 1;
                    queue.add(u);
                    seen[u] = true;
                }
            }
        }

        return weights;
    }

    public static void main(String[] args) {
        Graph graph = new AdjacencyList(10);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.addEdge(7, 4);
        graph.addEdge(7, 8);
        graph.addEdge(7, 9);

        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solve1(graph, 0)));
    }
}
