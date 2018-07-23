package tree.binary.examples.example_21;

import tree.binary.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Sum of all nodes
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n) (for the system stack)
     */
    public int solve1(Node<Integer> node) {
        if (node == null) return 0;

        return solve1(node.left) + solve1(node.right) + node.data;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(ExampleTree.HEAD));
    }
}
