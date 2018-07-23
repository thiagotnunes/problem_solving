package tree.binary.examples.example_19;

import tree.binary.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Maximum depth in the tree
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n) (for the system stack)
     */
    public <T> int solve1(Node<T> node) {
        if (node == null) return 0;

        int leftDepth = solve1(node.left);
        int rightDepth = solve1(node.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(ExampleTree.HEAD.left));
    }
}
