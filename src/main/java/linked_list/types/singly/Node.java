package linked_list.types.singly;

import java.util.Objects;

public class Node {
    public final int data;
    public Node next;

    public Node(int data) {
        this(data, null);
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return data == node.data &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {

        return Objects.hash(data, next);
    }
}
