package tree.exercises.exercise_8;

import tree.bst.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Check if a tree is height balanced
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(height)
     */
    public <T> boolean solve1(Node<T> node) {
        return balance(node) != -1;
    }

    private <T> int balance(Node<T> node) {
        if (node == null) return 0;

        int leftBalance = balance(node.left);
        int rightBalance = balance(node.right);

        if (leftBalance < 0 || rightBalance < 0) {
            return -1;
        } else if (Math.abs(leftBalance - rightBalance) > 1) {
            return -1;
        } else {
            return Math.max(leftBalance, rightBalance) + 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(ExampleTree.HEAD));
    }
}
