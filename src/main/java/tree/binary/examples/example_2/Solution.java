package tree.binary.examples.example_2;

import tree.types.binary.Node;

import java.util.function.Consumer;

/**
 * Pre order traversal
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n) (for the system stack)
     */
    public <T> void preOrder(Node<T> node, Consumer<T> f) {
        if (node == null) return;

        f.accept(node.data);
        preOrder(node.left, f);
        preOrder(node.right, f);
    }
}
