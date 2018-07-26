package tree.bst.examples.example_3;

import tree.bst.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Find min
 */
public class Solution {
    /**
     * Time complexity - O(height) (n in the worst case, not balanced)
     * Space complexity - O(1)
     */
    public int solve1(Node<Integer> node) {
        return solve1(node, Integer.MAX_VALUE);
    }

    private int solve1(Node<Integer> node, int min) {
        if (node == null) return min;

        return solve1(node.left, node.data);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(ExampleTree.HEAD));
    }
}
