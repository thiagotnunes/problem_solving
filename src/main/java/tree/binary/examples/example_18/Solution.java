package tree.binary.examples.example_18;

import tree.binary.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Find an element in binary tree
 */
public class Solution {
    /**
     * Recursive
     * Time complexity - O(n)
     * Space complexity - O(n) (for the system stack)
     */
    public <T> Node<T> solve1(Node<T> node, T toFind) {
        if (node == null) return null;
        if (node.data.equals(toFind)) return node;

        Node<T> leftNode = solve1(node.left, toFind);
        Node<T> rightNode = solve1(node.right, toFind);

        return leftNode != null ? leftNode : rightNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(ExampleTree.HEAD, 7));
    }
}
