package tree.bst.examples.example_2;

import tree.bst.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Find node
 */
public class Solution {
    /**
     * Time complexity - O(height) (n in the worst case, not balanced)
     * Space complexity - O(1)
     */
    public Boolean solve1(Node<Integer> node, int value) {
        if (node == null) return false;

        if (node.data == value) {
            return true;
        } else if (node.data > value) {
            return solve1(node.left, value);
        } else {
            return solve1(node.right, value);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(ExampleTree.HEAD, 7));
    }
}
