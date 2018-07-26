package tree.bst.examples.example_1;

import tree.types.binary.BinaryTree;
import tree.types.binary.Node;

/**
 * Create a BST from a sorted array
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public Node<Integer> solve1(int[] array) {
        return solve1(array, 0, array.length - 1);
    }

    private Node<Integer> solve1(int[] array, int lo, int hi) {
        if (lo > hi) return null;

        int mid = (hi - lo) / 2 + lo;
        Node<Integer> node = new Node<>(array[mid]);
        node.left = solve1(array, lo, mid - 1);
        node.right = solve1(array, mid + 1, hi);

        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        Node<Integer> node = solution.solve1(array);

        BinaryTree.print(node);
    }
}
