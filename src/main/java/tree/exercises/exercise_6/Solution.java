package tree.exercises.exercise_6;

import tree.bst.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Check if a tree is full
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(height)
     */
    public <T> boolean solve1(Node<T> node) {
        if (node == null) return true;

        if (node.left == null && node.right == null) {
            return true;
        } else if (node.left == null || node.right == null) {
            return false;
        } else {
            return solve1(node.left) && solve1(node.right);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(ExampleTree.HEAD));
    }
}
