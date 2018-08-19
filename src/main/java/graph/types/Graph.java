package graph.types;

public interface Graph {
    boolean addEdge(int from, int to, int weight);

    boolean addEdge(int from, int to);

    void addBiEdge(int from, int to);

    boolean removeEdge(int from, int to);

    void removeBiEdge(int from, int to);

    Iterable<Integer> neighbours(int v);

    Iterable<Edge> edgesFrom(int v);

    Iterable<Edge> allEdges();

    Iterable<Integer> allVertices();

    int inDegree(int v);

    int outDegree(int v);
}
