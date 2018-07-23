package tree.binary.examples.example_11;

import tree.binary.examples.ExampleTree;
import tree.types.binary.BinaryTree;
import tree.types.binary.Node;

/**
 * Copy tree
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public <T> Node<T> solve1(Node<T> node) {
        if (node == null) return null;

        Node<T> newNode = new Node<>(node.data);
        newNode.left = solve1(node.left);
        newNode.right = solve1(node.right);

        return newNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Node<Integer> result = solution.solve1(ExampleTree.HEAD);

        BinaryTree.print(result);
    }
}
