package tree.bst.examples.example_10;

import tree.bst.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Find ceil of a given value
 */
public class Solution {
    /**
     * Time complexity - O(height)
     * Space complexity - O(1)
     */
    public int solve1(Node<Integer> node, int value) {
        return solve1(node, value, Integer.MAX_VALUE);
    }

    private int solve1(Node<Integer> node, int value, int ceil) {
        if (node == null) return ceil;
        if (node.data <= value) return solve1(node.right, value, ceil);

        if (node.data < ceil) {
            return solve1(node.left, value, node.data);
        } else {
            return solve1(node.left, value, ceil);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(ExampleTree.HEAD, 4));
    }
}
