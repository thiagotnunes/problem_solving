package graph.types;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * V is the number of vertices.
 * E is the number of edges.
 * This representation uses O(V + E) space.
 */
public class EdgeList implements Graph {
    private final int vertices;
    private final int[] inDegree;
    private final int[] outDegree;
    private ArrayList<Edge> graph;

    public EdgeList(int vertices) {
        this.vertices = vertices;
        this.graph = new ArrayList<>();
        this.inDegree = new int[vertices];
        this.outDegree = new int[vertices];
    }

    // Time complexity - O(E)
    @Override
    public boolean addEdge(int from, int to, int weight) {
        if (from < 0 || from >= vertices) throw new RuntimeException("Node " + from + " does not exist");
        if (to < 0 || to >= vertices) throw new RuntimeException("Node " + to + " does not exist");

        Edge edge = null;
        for (Edge e : graph) {
            if (e.from == from && e.to == to) {
                edge = e;
                break;
            }
        }

        if (edge != null) {
            return false;
        } else {
            graph.add(new Edge(from, to, weight));
            inDegree[to]++;
            outDegree[from]++;
            return true;
        }
    }

    // Time complexity - O(E)
    @Override
    public boolean addEdge(int from, int to) {
        return addEdge(from, to, 1);
    }

    // Time complexity - O(E)
    @Override
    public void addBiEdge(int from, int to) {
        addEdge(from, to);
        addEdge(to, from);
    }

    // Time complexity - O(E)
    @Override
    public boolean removeEdge(int from, int to) {
        if (from < 0 || from >= vertices) throw new RuntimeException("Node " + from + " does not exist");
        if (to < 0 || to >= vertices) throw new RuntimeException("Node " + to + " does not exist");

        Iterator<Edge> it = graph.iterator();
        while (it.hasNext()) {
            Edge e = it.next();
            if (e.from == from && e.to == to) {
                it.remove();
                inDegree[to]--;
                outDegree[from]--;
                return true;
            }
        }

        return false;
    }

    // Time complexity - O(E)
    @Override
    public void removeBiEdge(int from, int to) {
        removeEdge(from, to);
        removeEdge(to, from);
    }

    // Time complexity - O(E)
    // Space complexity - O(V)
    @Override
    public Iterable<Integer> neighbours(int v) {
        if (v < 0 || v >= vertices) throw new RuntimeException("Node " + v + " does not exist");

        ArrayList<Integer> neighbours = new ArrayList<>();
        for (Edge e : graph) {
            if (e.from == v) {
                neighbours.add(e.to);
            }
        }

        return neighbours;
    }

    // Time complexity - O(E)
    // Space complexity - O(E)
    @Override
    public Iterable<Edge> edgesFrom(int v) {
        if (v < 0 || v >= vertices) throw new RuntimeException("Node " + v + " does not exist");

        ArrayList<Edge> edges = new ArrayList<>();
        for (Edge e : graph) {
            if (e.from == v) {
                edges.add(e);
            }
        }

        return edges;
    }

    // Time complexity - O(1)
    @Override
    public Iterable<Edge> allEdges() {
        return graph;
    }

    // Time complexity - O(V)
    // Space complexity - O(V)
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
        return inDegree[v];
    }

    // Time complexity - O(1)
    @Override
    public int outDegree(int v) {
        return outDegree[v];
    }
}
