package graph.types;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * V is the number of vertices.
 * E is the number of edges.
 * This representation uses O(V^2) space.
 */
public class AdjacencyMatrix implements Graph {
    private static final int EMPTY = Integer.MIN_VALUE;
    private final int vertices;
    private int[][] graph;
    private int[] inDegree;
    private int[] outDegree;

    public AdjacencyMatrix(int vertices) {
        this.vertices = vertices;
        graph = new int[vertices][];
        inDegree = new int[vertices];
        outDegree = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new int[vertices];
            Arrays.fill(graph[i], EMPTY);
        }
    }

    // Time complexity - O(1)
    @Override
    public boolean addEdge(int from, int to, int weight) {
        if (from < 0 || from >= vertices) throw new RuntimeException("Node " + from + " does not exist");
        if (to < 0 || to >= vertices) throw new RuntimeException("Node " + to + " does not exist");
        if (weight == EMPTY) throw new RuntimeException("Weight must be greater than " + EMPTY);

        if (graph[from][to] != EMPTY) {
            return false;
        } else {
            graph[from][to] = weight;
            inDegree[to]++;
            outDegree[from]++;
            return true;
        }
    }

    // Time complexity - O(1)
    @Override
    public boolean addEdge(int from, int to) {
        return addEdge(from, to, 1);
    }

    // Time complexity - O(1)
    @Override
    public void addBiEdge(int from, int to) {
        addEdge(from, to);
        addEdge(to, from);
    }

    // Time complexity - O(1)
    @Override
    public boolean removeEdge(int from, int to) {
        if (from < 0 || from >= vertices) throw new RuntimeException("Node " + from + " does not exist");
        if (to < 0 || to >= vertices) throw new RuntimeException("Node " + to + " does not exist");

        if (graph[from][to] == EMPTY) {
            return false;
        } else {
            graph[from][to] = EMPTY;
            inDegree[to]--;
            outDegree[from]--;
            return true;
        }
    }

    // Time complexity - O(1)
    @Override
    public void removeBiEdge(int from, int to) {
        removeEdge(from, to);
        removeEdge(to, from);
    }

    // Time complexity - O(V)
    // Space complexity - O(V)
    @Override
    public Iterable<Integer> neighbours(int v) {
        if (v < 0 || v >= vertices) throw new RuntimeException("Node " + v + " does not exist");

        ArrayList<Integer> neighbours = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            if (graph[v][i] != EMPTY) neighbours.add(i);
        }

        return neighbours;
    }

    // Time complexity - O(V)
    // Space complexity - O(V)
    @Override
    public Iterable<Edge> edgesFrom(int v) {
        if (v < 0 || v >= vertices) throw new RuntimeException("Node " + v + " does not exist");

        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            if (graph[v][i] != EMPTY) edges.add(new Edge(v, i, graph[v][i]));
        }

        return edges;
    }

    // Time complexity - O(E)
    // Space complexity - O(E)
    @Override
    public Iterable<Edge> allEdges() {
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (graph[j][i] != EMPTY) edges.add(new Edge(j, i, graph[j][i]));
            }
        }

        return edges;
    }

    // Time complexity - O(V)
    @Override
    public Iterable<Integer> allVertices() {
        ArrayList<Integer> allVertices = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            allVertices.add(i);
        }

        return allVertices;
    }

    // Time complexity - O(1)
    @Override
    public int inDegree(int v) {
        if (v < 0 || v >= vertices) throw new RuntimeException("Node " + v + " does not exist");

        return inDegree[v];
    }

    // Time complexity - O(1)
    @Override
    public int outDegree(int v) {
        if (v < 0 || v >= vertices) throw new RuntimeException("Node " + v + " does not exist");

        return outDegree[v];
    }
}
