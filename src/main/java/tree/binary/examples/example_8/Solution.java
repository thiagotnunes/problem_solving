package tree.binary.examples.example_8;

import tree.binary.examples.ExampleTree;
import tree.types.binary.BinaryTree;
import tree.types.binary.Node;

/**
 * Nth pre order node
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public <T> void nthPreOrder(Node<T> node, int n) {
        nthPreOrder(node, n, 0);
    }

    private <T> int nthPreOrder(Node<T> node, int n, int count) {
        if (node == null) return count;

        if (count == n) {
            System.out.println(node.data);
            return count + 1;
        }

        int newCount = count + 1;
        newCount = nthPreOrder(node.left, n, newCount);
        newCount = nthPreOrder(node.right, n, newCount);

        return newCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        BinaryTree.preOrder(ExampleTree.HEAD, System.out::println);
        solution.nthPreOrder(ExampleTree.HEAD, 6);
    }
}
