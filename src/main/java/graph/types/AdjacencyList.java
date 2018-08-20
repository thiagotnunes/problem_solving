package graph.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.StreamSupport;

/**
 * V is the number of vertices.
 * E is the number of edges.
 * This representation uses O(V + E) space.
 */
public class AdjacencyList implements Graph {
    private static class AdjacencyNode {
        private final int to;
        private int weight;
        private AdjacencyNode next;

        AdjacencyNode(int to, int weight) {
            this.to = to;
            this.weight = weight;
            this.next = null;
        }
    }

    private static class EdgeIterator implements Iterator<Edge> {
        private int from;
        private AdjacencyNode current;

        EdgeIterator(int from, AdjacencyNode current) {
            this.from = from;
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Edge next() {
            int to = current.to;
            int weight = current.weight;
            current = current.next;
            return new Edge(from, to, weight);
        }
    }

    private final int vertices;
    private final AdjacencyNode[] graph;
    private final int[] inDegree;
    private final int[] outDegree;

    public AdjacencyList(int vertices) {
        this.vertices = vertices;
        this.graph = new AdjacencyNode[vertices];
        this.inDegree = new int[vertices];
        this.outDegree = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            graph[i] = new AdjacencyNode(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
    }

    // Time complexity - O(V)
    @Override
    public boolean addEdge(int from, int to, int weight) {
        if (from < 0 || from >= vertices) throw new RuntimeException("Node " + from + " does not exist");
        if (to < 0 || to >= vertices) throw new RuntimeException("Node " + to + " does not exist");

        boolean edgeFound = false;
        AdjacencyNode current = graph[from];
        while (current.next != null) {
            if (current.next.to == to) {
                edgeFound = true;
                break;
            }
            current = current.next;
        }

        if (edgeFound) {
            return false;
        } else {
            current.next = new AdjacencyNode(to, weight);
            inDegree[to]++;
            outDegree[from]++;
            return true;
        }
    }

    // Time complexity - O(V)
    @Override
    public boolean addEdge(int from, int to) {
        return addEdge(from, to, 1);
    }

    // Time complexity - O(V)
    @Override
    public void addBiEdge(int from, int to) {
        addEdge(from, to);
        addEdge(to, from);
    }

    // Time complexity - O(V)
    @Override
    public boolean removeEdge(int from, int to) {
        if (from < 0 || from >= vertices) throw new RuntimeException("Node " + from + " does not exist");
        if (to < 0 || to >= vertices) throw new RuntimeException("Node " + to + " does not exist");

        AdjacencyNode current = graph[from];
        while (current != null && current.next != null) {
            if (current.next.to == to) {
                current.next = current.next.next;
                inDegree[to]--;
                outDegree[from]--;
                return true;
            }
        }

        return false;
    }

    // Time complexity - O(V)
    @Override
    public void removeBiEdge(int from, int to) {
        removeEdge(from, to);
        removeEdge(to, from);
    }

    // Time complexity - O(1)
    @Override
    public Iterable<Integer> neighbours(int v) {
        if (v < 0 || v >= vertices) throw new RuntimeException("Node " + v + " does not exist");

        return () -> StreamSupport.stream(edgesFrom(v).spliterator(), false).map(edge -> edge.to).iterator();
    }

    // Time complexity - O(1)
    @Override
    public Iterable<Edge> edgesFrom(int v) {
        if (v < 0 || v >= vertices) throw new RuntimeException("Node " + v + " does not exist");

        return () -> new EdgeIterator(v, graph[v].next);
    }

    // Time complexity - O(E)
    // Space complexity - O(E)
    @Override
    public Iterable<Edge> allEdges() {
        ArrayList<Edge> allEdges = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            AdjacencyNode current = graph[i].next;
            while (current != null) {
                allEdges.add(new Edge(i, current.to, current.weight));
                current = current.next;
            }
        }

        return allEdges;
    }

    // Time complexity - O(1)
    @Override
    public int numberOfVertices() {
        return vertices;
    }

    // Time complexity - O(1)
    @Override
    public int inDegree(int v) {
        return inDegree[v];
    }

    // Time complexity - O(1)
    @Override
    public int outDegree(int v) {
        return outDegree[v];
    }
}
