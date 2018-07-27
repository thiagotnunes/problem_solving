package tree.exercises.exercise_4;

import tree.bst.examples.ExampleTree;
import tree.types.binary.BinaryTree;
import tree.types.binary.Node;

import java.util.ArrayDeque;
import java.util.function.Consumer;

/**
 * DFS without using system stack
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
            Node<T> node = stack.pop();
            f.accept(node.data);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        BinaryTree.preOrder(ExampleTree.HEAD, System.out::println);
        System.out.println();
        solution.solve1(ExampleTree.HEAD, System.out::println);
    }
}
