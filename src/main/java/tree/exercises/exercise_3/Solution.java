package tree.exercises.exercise_3;

import tree.bst.examples.ExampleTree;
import tree.types.binary.BinaryTree;
import tree.types.binary.Node;

/**
 * Write a function to delete a node from a BST
 */
public class Solution {

    /**
     * Time complexity - O(height)
     * Space complexity - O(height)
     */
    public Node<Integer> solve1(Node<Integer> node, int value) {
        if (node == null) return null;

        if (node.data == value) {
            if (hasNoChildren(node)) {
                return null;
            } else if (hasOneChild(node)) {
                return node.left != null ? node.left : node.right;
            } else {
                Node<Integer> successor = findSuccessor(node.right);
                node.data = successor.data;
                solve1(node.right, successor.data);
                return node;
            }
        } else if (node.data > value) {
            node.left = solve1(node.left, value);
            return node;
        } else {
            node.right = solve1(node.right, value);
            return node;
        }
    }

    private Node<Integer> findSuccessor(Node<Integer> node) {
        if (node == null) return null;

        if (node.left == null) {
            return node;
        } else {
            return findSuccessor(node.left);
        }
    }

    private boolean hasOneChild(Node<Integer> node) {
        return (node.left != null && node.right == null) || (node.left == null && node.right != null);
    }

    private boolean hasNoChildren(Node<Integer> node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Node<Integer> node = solution.solve1(ExampleTree.HEAD, 4);

        BinaryTree.print(node);
    }
}
