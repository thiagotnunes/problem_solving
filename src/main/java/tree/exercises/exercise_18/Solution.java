package tree.exercises.exercise_18;

import tree.bst.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Find the nth smallest element in a BST
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(height)
     */
    public void solve1(Node<Integer> node, int n) {
        nthSmallest(node, n, 0);
    }

    private int nthSmallest(Node<Integer> node, int n, int count) {
        if (node == null) return count;

        count = nthSmallest(node.left, n, count);
        count++;
        if (count == n) {
            System.out.println(node.data);
        }
        count = nthSmallest(node.right, n, count);

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.solve1(ExampleTree.HEAD, 4);
    }
}
