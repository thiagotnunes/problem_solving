package tree.binary.examples.example_9;

import tree.binary.examples.ExampleTree;
import tree.types.binary.BinaryTree;
import tree.types.binary.Node;

/**
 * Nth post order node
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public <T> void nthPostOrder(Node<T> node, int n) {
        nthPostOrder(node, n, 0);
    }

    private <T> int nthPostOrder(Node<T> node, int n, int count) {
        if (node == null) return count;

        int newCount = count;
        newCount = nthPostOrder(node.left, n, newCount);
        newCount = nthPostOrder(node.right, n, newCount);
        if (newCount == n) {
            System.out.println(node.data);
        }
        newCount = newCount + 1;

        return newCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        BinaryTree.postOrder(ExampleTree.HEAD, System.out::println);
        solution.nthPostOrder(ExampleTree.HEAD, 4);
    }
}
