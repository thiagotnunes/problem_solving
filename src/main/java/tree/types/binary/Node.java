package tree.types.binary;

import java.util.Objects;

public class Node<T> {
    public
    T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data) {
        this(data, null, null);
    }

    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(data, node.data) &&
                Objects.equals(left, node.left) &&
                Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {

        return Objects.hash(data, left, right);
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
