package tree.bst.examples.example_7;

import tree.types.binary.BinaryTree;
import tree.types.binary.Node;

/**
 * Trim the nodes outside of a range
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public Node<Integer> solve1(Node<Integer> node, int min, int max) {
        if (node == null) return null;

        if (node.data < min) {
            return solve1(node.right, min, max);
        } else if (node.data > max) {
            return solve1(node.left, min, max);
        } else {
            node.left = solve1(node.left, min, max);
            node.right = solve1(node.right, min, max);
            return node;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        /**
         *        4
         *     2     6
         *    1 3   5 7
         */
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        Node<Integer> seven = new Node<>(7);

        four.left = two;
        four.right = six;
        two.left = one;
        two.right = three;
        six.left = five;
        six.right = seven;

        Node<Integer> result = solution.solve1(four, 1, 4);
        BinaryTree.print(result);
    }
}
