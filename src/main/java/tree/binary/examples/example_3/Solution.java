package tree.binary.examples.example_3;

import tree.types.binary.Node;

import java.util.function.Consumer;

/**
 * Post order traversal
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n) (for the system stack)
     */
    public <T> void postOrder(Node<T> node, Consumer<T> f) {
        if (node == null) return;

        postOrder(node.left, f);
        postOrder(node.right, f);
        f.accept(node.data);
    }
}
