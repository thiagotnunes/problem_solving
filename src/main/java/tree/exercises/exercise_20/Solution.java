package tree.exercises.exercise_20;

import tree.bst.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Find the ceil of a key in BST
 */
public class Solution {
    /**
     * Time complexity - O(height)
     * Space complexity - O(height)
     */
    public int solve1(Node<Integer> node, int key) {
        return ceil(node, key, Integer.MAX_VALUE);
    }

    private int ceil(Node<Integer> node, int key, int ceil) {
        if (node == null) return ceil;

        if (node.data == key) {
            return ceil(node.right, key, ceil);
        } else if (node.data < key) {
            return ceil(node.right, key, ceil);
        } else {
            return ceil(node.left, key, node.data);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(ExampleTree.HEAD, 5));
    }
}
