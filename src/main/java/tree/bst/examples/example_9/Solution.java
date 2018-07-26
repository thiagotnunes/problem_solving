package tree.bst.examples.example_9;

import tree.bst.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Find floor of a given value
 */
public class Solution {
    /**
     * Time complexity - O(height)
     * Space complexity - O(1)
     */
    public int solve1(Node<Integer> node, int value) {
        return solve1(node, value, Integer.MIN_VALUE);
    }

    private int solve1(Node<Integer> node, int value, int floor) {
        if (node == null) return floor;
        if (node.data >= value) return solve1(node.left, value, floor);

        if (node.data > floor) {
            return solve1(node.right, value, node.data);
        } else {
            return solve1(node.right, value, floor);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(ExampleTree.HEAD, 10));
    }
}
