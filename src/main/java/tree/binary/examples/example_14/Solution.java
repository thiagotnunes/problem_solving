package tree.binary.examples.example_14;

import tree.binary.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Number of leaf nodes
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n) (for the system stack)
     */
    public <T> int solve1(Node<T> node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;

        int leftLeaves = solve1(node.left);
        int rightLeaves = solve1(node.right);

        return leftLeaves + rightLeaves;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(ExampleTree.HEAD));
    }
}
