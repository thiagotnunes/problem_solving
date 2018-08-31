package graph.examples.example_5;

import graph.types.AdjacencyMatrix;
import graph.types.Graph;

import java.util.ArrayDeque;

/**
 * Topological sort
 * FIXME: Check if the graph does not have a cycle
 */
public class Solution {
    /**
     * DFS
     * Time complexity - O(V + E)
     * Space complexity - O(V)
     */
    public void solve1(Graph graph) {
        int vertices = graph.numberOfVertices();
        boolean[] seen = new boolean[vertices];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < vertices; i++) {
            if (!seen[i]) {
                seen[i] = true;
                dfs(graph, i, seen, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private void dfs(Graph graph, int v, boolean[] seen, ArrayDeque<Integer> stack) {
        for (int u : graph.neighbours(v)) {
            if (!seen[u]) {
                seen[u] = true;
                dfs(graph, u, seen, stack);
            }
        }
        stack.push(v);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Graph graph = new AdjacencyMatrix(9);

        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 2);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);

        solution.solve1(graph);
    }
}
