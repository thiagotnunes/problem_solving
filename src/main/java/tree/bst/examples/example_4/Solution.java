package tree.bst.examples.example_4;

import tree.bst.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Find max
 */
public class Solution {
    /**
     * Time complexity - O(height) (n in the worst case, not balanced)
     * Space complexity - O(1)
     */
    public int solve1(Node<Integer> node) {
        return solve1(node, Integer.MIN_VALUE);
    }

    private int solve1(Node<Integer> node, int max) {
        if (node == null) return max;

        return solve1(node.right, node.data);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(ExampleTree.HEAD));
    }
}
