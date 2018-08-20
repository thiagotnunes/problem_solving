package graph.types;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class GraphTest {

    private final Constructor<?> constructor;
    private Graph graph;

    @Parameterized.Parameters
    public static Collection<Class<? extends Graph>> graphs() {
        return Arrays.asList(AdjacencyList.class, AdjacencyMatrix.class, EdgeList.class);
    }

    public GraphTest(Class<? extends Graph> clazz) throws Exception {
        this.constructor = clazz.getConstructor(Integer.TYPE);
    }

    @Before
    public void setUp() throws Exception {
        graph = (Graph) constructor.newInstance(10);
    }

    @Test
    public void addEdgeBetweenNodesWithoutWeight() {
        assertThat(graph.addEdge(0, 1), equalTo(true));
        assertThat(graph.edgesFrom(0), hasItems(new Edge(0, 1, 1)));
    }

    @Test
    public void addEdgeBetweenNodesWithWeight() {
        assertThat(graph.addEdge(0, 1, 10), equalTo(true));
        assertThat(graph.edgesFrom(0), hasItems(new Edge(0, 1, 10)));
    }

    @Test
    public void returnsFalseWhenAddingEdgeThatAlreadyExists() {
        graph.addEdge(0, 1, 10);

        assertThat(graph.addEdge(0, 1, 20), equalTo(false));
        assertThat(graph.edgesFrom(0), hasItems(new Edge(0, 1, 10)));
    }

    @Test(expected = RuntimeException.class)
    public void returnsErrorWhenAddingEdgeFromUnexistingVertex() {
        graph.addEdge(10, 1);
    }

    @Test(expected = RuntimeException.class)
    public void returnsErrorWhenAddingEdgeToUnexistingVertex() {
        graph.addEdge(1, 10);
    }

    @Test(expected = RuntimeException.class)
    public void returnsErrorWhenAddingEdgeFromNegativeVertex() {
        graph.addEdge(-1, 1);
    }

    @Test(expected = RuntimeException.class)
    public void returnsErrorWhenAddingEdgeToNegativeVertex() {
        graph.addEdge(1, -1);
    }

    @Test
    public void addBiEdgeBetweenNodesWithoutWeight() {
        graph.addBiEdge(0, 1);

        assertThat(graph.edgesFrom(0), hasItems(new Edge(0, 1, 1)));
        assertThat(graph.edgesFrom(1), hasItems(new Edge(1, 0, 1)));
    }

    @Test
    public void removesExistingEdge() {
        graph.addEdge(0, 1);

        assertThat(graph.removeEdge(0, 1), equalTo(true));
        assertThat(graph.edgesFrom(0), hasItems());
    }

    @Test
    public void doesNothingWhenRemovingUnexistingEdge() {
        assertThat(graph.removeEdge(0, 1), equalTo(false));
        assertThat(graph.edgesFrom(0), hasItems());
    }

    @Test
    public void removesBiEdge() {
        graph.addBiEdge(0, 1);

        graph.removeBiEdge(0, 1);

        assertThat(graph.edgesFrom(0), hasItems());
        assertThat(graph.edgesFrom(1), hasItems());
    }

    @Test
    public void returnsNeighboursForGivenVertex() {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        assertThat(graph.neighbours(0), hasItems(1, 2));
    }

    @Test
    public void returnsEdgesFromGivenVertex() {
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 20);
        graph.addEdge(1, 2, 30);
        graph.addEdge(2, 3, 40);

        assertThat(graph.edgesFrom(0), hasItems(new Edge(0, 1, 10), new Edge(0, 2, 20)));
    }

    @Test
    public void returnsAllEdges() {
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 20);
        graph.addEdge(1, 2, 30);
        graph.addEdge(2, 3, 40);

        assertThat(
                graph.allEdges(),
                hasItems(
                        new Edge(0, 1, 10),
                        new Edge(0, 2, 20),
                        new Edge(1, 2, 30),
                        new Edge(2, 3, 40)
                )
        );
    }

    @Test
    public void returnsNumberOfVertices() {
        assertThat(graph.numberOfVertices(), equalTo(10));
    }

    @Test
    public void returnsInDegreeOfGivenNode() {
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 20);
        graph.addEdge(1, 2, 30);
        graph.addEdge(2, 3, 40);

        assertThat(graph.inDegree(2), equalTo(2));
    }

    @Test
    public void retunsOutDegreeOfGivenNode() {
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 20);
        graph.addEdge(1, 2, 30);
        graph.addEdge(2, 3, 40);

        assertThat(graph.outDegree(2), equalTo(1));
    }
}