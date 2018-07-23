package tree.binary.examples.example_7;

import tree.types.binary.Node;

/**
 * Depth of a binary tree
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public <T> int solve1(Node<T> node) {
        if (node == null) return 0;

        int leftDepth = solve1(node.left);
        int rightDepth = solve1(node.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
