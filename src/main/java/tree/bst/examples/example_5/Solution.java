package tree.bst.examples.example_5;

import tree.bst.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Is the tree a BST
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(height) (for the system stack)
     */
    public boolean solve1(Node<Integer> node) {
        return solve1(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean solve1(Node<Integer> node, int lo, int hi) {
        if (node == null) return true;

        if (node.data > lo && node.data <= hi) {
            return solve1(node.left, lo, node.data) && solve1(node.right, node.data, hi);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(ExampleTree.HEAD));
    }
}
