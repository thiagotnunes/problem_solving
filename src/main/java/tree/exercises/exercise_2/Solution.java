package tree.exercises.exercise_2;

import tree.types.binary.BinaryTree;
import tree.types.binary.Node;
import util.Pair;

/**
 * Construct a BST given inorder and postorder traversals
 */
public class Solution {
    /**
     * Time complexity - O(n^2)
     * Space complexity - O(n)
     */
    public Node<Integer> solve1(int[] inOrder, int[] postOrder) {
        return buildBst(inOrder, postOrder, postOrder.length - 1, 0, inOrder.length - 1).first;
    }

    private Pair<Node<Integer>, Integer> buildBst(int[] inOrder, int[] postOrder, int postOrderI, int inOrderLo, int inOrderHi) {
        if (inOrderLo > inOrderHi) return new Pair<>(null, postOrderI);

        Node<Integer> node = new Node<>(postOrder[postOrderI]);
        int inOrderMid = binarySearch(inOrder, inOrderLo, inOrderHi, node.data);
        Pair<Node<Integer>, Integer> rightResult = buildBst(inOrder, postOrder, postOrderI - 1, inOrderMid + 1, inOrderHi);
        Pair<Node<Integer>, Integer> leftResult = buildBst(inOrder, postOrder, rightResult.second, inOrderLo, inOrderMid - 1);
        node.left = leftResult.first;
        node.right = rightResult.first;
        postOrderI = leftResult.second;

        return new Pair<>(node, postOrderI);
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

        int[] inOrder = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] postOrder = new int[]{1, 3, 2, 5, 4, 7, 10, 9, 8, 6};

        Node<Integer> node = solution.solve1(inOrder, postOrder);

        BinaryTree.print(node);
        BinaryTree.inOrder(node, key -> System.out.print(key + " "));
        System.out.println();
        BinaryTree.postOrder(node, key -> System.out.print(key + " "));
    }
}
