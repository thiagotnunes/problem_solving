package tree.binary.examples.example_10;

import tree.binary.examples.ExampleTree;
import tree.types.binary.BinaryTree;
import tree.types.binary.Node;

/**
 * Nth in order node
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public <T> void nthInOrder(Node<T> node, int n) {
        nthInOrder(node, n, 0);
    }

    private <T> int nthInOrder(Node<T> node, int n, int count) {
        if (node == null) return count;

        int newCount = count;
        newCount = nthInOrder(node.left, n, newCount);
        if (newCount == n) {
            System.out.println(node.data);
        }
        newCount = newCount + 1;
        newCount = nthInOrder(node.right, n, newCount);

        return newCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        BinaryTree.inOrder(ExampleTree.HEAD, System.out::println);
        solution.nthInOrder(ExampleTree.HEAD, 2);
    }
}
