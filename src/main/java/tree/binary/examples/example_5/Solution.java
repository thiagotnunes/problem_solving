package tree.binary.examples.example_5;

import tree.types.binary.Node;

import java.util.ArrayDeque;
import java.util.function.Consumer;

/**
 * Level order traversal
 */
public class Solution {
    /**
     * Queue based
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public <T> void levelOrder(Node<T> node, Consumer<T> f) {
        ArrayDeque<Node<T>> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node<T> current = queue.removeFirst();
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
            f.accept(current.data);
        }
    }
}
