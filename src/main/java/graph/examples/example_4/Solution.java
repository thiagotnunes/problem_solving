package graph.examples.example_4;

import graph.types.AdjacencyList;
import graph.types.Graph;

import java.util.ArrayDeque;

/**
 * Test if there is a cycle in the graph
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
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < vertices; i++) {
            if (!seen[i]) {
                seen[i] = true;
                stack.push(i);
                if (dfs(graph, i, seen, stack)) return true;
                stack.pop();
            }
        }
        return false;
    }

    private boolean dfs(Graph graph, int v, boolean[] seen, ArrayDeque<Integer> stack) {
        for (int u : graph.neighbours(v)) {
            if (stack.contains(u)) return true;

            if (!seen[u]) {
                seen[u] = true;
                stack.push(u);
                if (dfs(graph, u, seen, stack)) return true;
                stack.pop();
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Graph graph = new AdjacencyList(10);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);
        graph.addEdge(5, 7);

        graph.addEdge(7, 4);
        graph.addEdge(7, 8);
        graph.addEdge(7, 9);
        graph.addEdge(4, 9);
        graph.addEdge(9, 7);

        System.out.println(solution.solve1(graph));
    }
}
