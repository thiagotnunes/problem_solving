package linked_list.types.doubly;

import java.util.Objects;

public class Node {
    public Node previous;
    public final int data;
    public Node next;

    public Node(int data) {
        this(null, data, null);
    }

    public Node(Node previous, int data, Node next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return data == node.data &&
                Objects.equals(previous, node.previous) &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(previous, data, next);
    }
}
