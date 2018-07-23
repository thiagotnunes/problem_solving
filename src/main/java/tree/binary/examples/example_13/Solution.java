package tree.binary.examples.example_13;

import tree.binary.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Number of elements of a binary tree
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public <T> int solve1(Node<T> node) {
        if (node == null) return 0;

        int leftElements = solve1(node.left);
        int rightElements = solve1(node.right);

        return leftElements + rightElements + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(ExampleTree.HEAD));
    }
}
