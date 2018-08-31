package graph.examples.example_3;

import graph.types.AdjacencyList;
import graph.types.Graph;

/**
 * Test if graph is connected
 */
public class Solution {
    /**
     * DFS
     * Time complexity - O(V + E)
     * Space complexity - O(V)
     */
    public boolean solve1(Graph graph) {
        int vertices = graph.numberOfVertices();
        boolean[] seen = new boolean[vertices];

        dfs(graph, 0, seen);

        for (int i = 0; i < seen.length; i++) {
            if (!seen[i]) return false;
        }

        return true;
    }

    private void dfs(Graph graph, int v, boolean[] seen) {
        seen[v] = true;
        for (int u : graph.neighbours(v)) {
            if (!seen[u]) {
                dfs(graph, u, seen);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
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

        System.out.println(solution.solve1(graph));
    }
}
