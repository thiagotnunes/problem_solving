package tree.binary.examples.example_1;

import tree.types.binary.BinaryTree;
import tree.types.binary.Node;

/**
 * Create a complete binary tree for an array
 */
public class Solution {
    /**
     * Heap is a complete binary tree
     * Time complexity - O(n)
     * Space complexity - O(logn) (for the system stack)
     */
    public Node<Integer> solve1(int[] array) {
        return solve1(array, 0);
    }

    private Node<Integer> solve1(int[] array, int i) {
        if (i >= array.length) return null;

        Node<Integer> node = new Node<>(array[i]);
        node.left = solve1(array, 2 * i + 1);
        node.right = solve1(array, 2 * i + 2);

        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {5, 4, 6, 3, 7, 2, 8, 1, 9, 10};

        Node<Integer> node = solution.solve1(array);

        BinaryTree.print(node);
    }

}
