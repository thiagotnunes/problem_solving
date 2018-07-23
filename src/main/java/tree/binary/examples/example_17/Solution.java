package tree.binary.examples.example_17;

import tree.binary.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Find max
 */
public class Solution {
    /**
     * Recursive
     * Time complexity - O(n)
     * Space complexity - O(n) (for the system stack)
     */
    public int solve1(Node<Integer> node) {
        return solve1(node, Integer.MIN_VALUE);
    }

    private int solve1(Node<Integer> node, int max) {
        if (node == null) return max;

        int leftMax = solve1(node.left, max);
        int rightMax = solve1(node.right, max);
        int tmpMax = Math.max(Math.max(leftMax, rightMax), node.data);

        return tmpMax > max ? tmpMax : max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(ExampleTree.HEAD));
    }
}
