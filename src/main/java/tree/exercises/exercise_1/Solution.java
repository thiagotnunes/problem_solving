package tree.exercises.exercise_1;

import tree.types.binary.BinaryTree;
import tree.types.binary.Node;
import util.Pair;

/**
 * Construct a tree given inorder and preorder traversals
 */
public class Solution {
    /**
     * Time complexity - O(n^2) (when the tree is left / right skewed)
     * Space complexity - O(n) (for the system stack)
     */
    public Node<Integer> solve1(int[] inOrder, int[] preOrder) {
        return buildBst(inOrder, preOrder, 0, 0, inOrder.length - 1).first;
    }

    private Pair<Node<Integer>, Integer> buildBst(int[] inOrder, int[] preOrder, int preOrderI, int inOrderLo, int inOrderHi) {
        if (inOrderLo > inOrderHi) return new Pair<>(null, preOrderI);

        Node<Integer> node = new Node<>(preOrder[preOrderI]);

        int inOrderMid = binarySearch(inOrder, inOrderLo, inOrderHi, node.data);
        Pair<Node<Integer>, Integer> leftResult = buildBst(inOrder, preOrder, preOrderI + 1, inOrderLo, inOrderMid - 1);
        Pair<Node<Integer>, Integer> rightResult = buildBst(inOrder, preOrder, leftResult.second, inOrderMid + 1, inOrderHi);
        node.left = leftResult.first;
        node.right = rightResult.first;
        preOrderI = rightResult.second;

        return new Pair<>(node, preOrderI);
    }

    private int binarySearch(int[] array, int lo, int hi, int key) {
        if (lo > hi) return -1;

        int mid = (hi - lo) / 2 + lo;
        int data = array[mid];
        if (data == key) {
            return mid;
        } else if (data > key) {
            return binarySearch(array, lo, mid - 1, key);
        } else {
            return binarySearch(array, mid + 1, hi, key);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] inOrder = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] preOrder = {6, 4, 2, 1, 3, 5, 8, 7, 9, 10};

        Node<Integer> node = solution.solve1(inOrder, preOrder);
        BinaryTree.print(node);

        BinaryTree.inOrder(node, k -> System.out.print(k + " "));
        System.out.println();
        BinaryTree.preOrder(node, k -> System.out.print(k + " "));
    }
}
