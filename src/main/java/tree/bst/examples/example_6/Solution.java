package tree.bst.examples.example_6;

import tree.bst.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Least common ancestor
 */
public class Solution {
    /**
     * Time complexity - O(height)
     * Space complexity - O(height) (for the system stack)
     */
    public <T> Node<T> solve1(Node<T> head, Node<T> node1, Node<T> node2) {
        if (head == null) return null;
        if (head.equals(node1)) return node1;
        if (head.equals(node2)) return node2;

        Node<T> leftNode = solve1(head.left, node1, node2);
        Node<T> rightNode = solve1(head.right, node1, node2);
        if (leftNode != null && rightNode != null) {
            return head;
        } else if (leftNode != null) {
            return leftNode;
        } else {
            return rightNode;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(ExampleTree.HEAD, ExampleTree.HEAD.left.right, ExampleTree.HEAD.right.left).data);
    }
}
