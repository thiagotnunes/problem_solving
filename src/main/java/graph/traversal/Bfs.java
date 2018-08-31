package graph.traversal;

import graph.types.AdjacencyList;
import graph.types.Graph;

import java.util.ArrayDeque;
import java.util.function.Consumer;

public class Bfs {
    public void bfs(Graph graph, int from, Consumer<Integer> f) {
        int vertices = graph.numberOfVertices();
        boolean[] seen = new boolean[vertices];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.add(from);
        seen[from] = true;

        while (!queue.isEmpty()) {
            int current = queue.remove();
            f.accept(current);

            for (int u : graph.neighbours(current)) {
                if (!seen[u]) {
                    seen[u] = true;
                    queue.add(u);
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

        new Bfs().bfs(graph, 0, System.out::println);
    }
}
