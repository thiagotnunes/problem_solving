package tree.binary.examples.example_4;

import tree.types.binary.Node;

import java.util.function.Consumer;

/**
 * In order traversal
 */
public class Solution {
    public <T> void inOrder(Node<T> node, Consumer<T> f) {
        if (node == null) return;

        inOrder(node.left, f);
        f.accept(node.data);
        inOrder(node.right, f);
    }
}
