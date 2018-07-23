package tree.binary.examples.example_22;

import tree.binary.examples.ExampleTree;
import tree.types.binary.BinaryTree;
import tree.types.binary.Node;

import java.util.ArrayDeque;
import java.util.function.Consumer;

/**
 * Iterative pre-order
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public <T> void solve1(Node<T> head, Consumer<T> f) {
        ArrayDeque<Node<T>> stack = new ArrayDeque<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            Node<T> current = stack.pop();
            f.accept(current.data);

            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        BinaryTree.preOrder(ExampleTree.HEAD, System.out::println);
        System.out.println("----");
        solution.solve1(ExampleTree.HEAD, System.out::println);
    }
}
