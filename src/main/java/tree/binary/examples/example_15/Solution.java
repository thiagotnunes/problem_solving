package tree.binary.examples.example_15;

import tree.binary.examples.ExampleTree;
import tree.types.binary.Node;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * Print all the paths from root to leaves
 */
public class Solution {
    public <T> void solve1(Node<T> node) {
        solve1(node, new ArrayDeque<>());
    }

    private <T> void solve1(Node<T> node, ArrayDeque<Node<T>> stack) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
            for (Node<T> current : stack) {
                System.out.print(current.data + " ");
            }
            System.out.println();
        } else {
            stack.push(node);
            solve1(node.left, stack);
            solve1(node.right, stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.solve1(ExampleTree.HEAD);
    }
}
