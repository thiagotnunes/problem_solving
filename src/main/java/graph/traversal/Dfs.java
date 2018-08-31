package graph.traversal;

import graph.types.AdjacencyList;
import graph.types.Edge;
import graph.types.Graph;

import java.util.ArrayDeque;
import java.util.function.Consumer;

/**
 * Depth first search in graphs
 * Time complexity - O(V + E)
 * Space complexity - O(V)
 */
public class Dfs {
    public void dfs(Graph graph, int from, Consumer<Integer> beforeF, Consumer<Integer> afterF) {
        int vertices = graph.numberOfVertices();
        boolean[] seen = new boolean[vertices];

        dfs(graph, from, beforeF, afterF, seen);
    }

    private void dfs(Graph graph, int v, Consumer<Integer> beforeF, Consumer<Integer> afterF, boolean[] seen) {
        if (!seen[v]) {
            seen[v] = true;
            beforeF.accept(v);

            for (Edge edge : graph.edgesFrom(v)) {
                dfs(graph, edge.to, beforeF, afterF, seen);
            }

            afterF.accept(v);
        }
    }

    public void iterativeDfs(Graph graph, int from, Consumer<Integer> f) {
        int vertices = graph.numberOfVertices();
        boolean[] seen = new boolean[vertices];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(from);
        seen[from] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            f.accept(current);

            for (int u : graph.neighbours(current)) {
                if (!seen[u]) {
                    stack.push(u);
                    seen[u] = true;
                }
            }
        }
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

        new Dfs().iterativeDfs(graph, 0, System.out::println);
    }
}
