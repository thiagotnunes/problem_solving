package tree.bst.examples.example_8;

import tree.bst.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Print the nodes in range
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(height)
     */
    public void solve1(Node<Integer> node, int min, int max) {
        if (node == null) return;

        if (node.data < min) {
            solve1(node.right, min, max);
        } else if(node.data > max) {
            solve1(node.left, min, max);
        } else {
            System.out.println(node.data);
            solve1(node.left, min, max);
            solve1(node.right, min, max);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.solve1(ExampleTree.HEAD, 2, 4);
    }
}
