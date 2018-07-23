package tree.binary.examples.example_20;

import tree.binary.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Number of full nodes
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n) (for the system stack)
     */
    public <T> int solve1(Node<T> node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;

        int leftNodes = solve1(node.left);
        int rightNodes = solve1(node.right);

        if (node.left != null && node.right != null) {
            return leftNodes + rightNodes + 1;
        } else {
            return leftNodes + rightNodes;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(ExampleTree.HEAD));
    }
}
