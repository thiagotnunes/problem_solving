package tree.exercises.exercise_19;

import tree.bst.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Find the floor of a key in BST
 */
public class Solution {
    /**
     * Time complexity - O(height)
     * Space complexity - O(height)
     */
    public int solve1(Node<Integer> node, int key) {
        return floor(node, key, Integer.MIN_VALUE);
    }

    private int floor(Node<Integer> node, int key, int floor) {
        if (node == null) return floor;

        if (node.data >= key) {
            return floor(node.left, key, floor);
        } else {
            return floor(node.right, key, node.data);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(ExampleTree.HEAD, 7));
    }
}
