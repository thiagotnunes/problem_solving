package tree.binary.examples.example_6;

import tree.types.binary.Node;

import java.util.ArrayDeque;
import java.util.function.Consumer;

/**
 * Depth first without using system stack / recursion
 */
public class Solution {
    /**
     * Stack
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public <T> void depthFirst(Node<T> node, Consumer<T> f) {
        ArrayDeque<Node<T>> stack = new ArrayDeque<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node<T> current = stack.pop();

            f.accept(current.data);
            if (current.left != null) stack.push(current.left);
            if (current.right != null) stack.push(current.right);
        }
    }
}
