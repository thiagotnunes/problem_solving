package tree.exercises.exercise_17;

import tree.bst.examples.ExampleTree;
import tree.types.binary.Node;

import java.util.ArrayDeque;

/**
 * Print the nodes of the tree in zig zag fashion
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public <T> void solve1(Node<T> head) {
        boolean leftToRight = true;
        ArrayDeque<Node<T>> tmpStack;
        ArrayDeque<Node<T>> currentStack = new ArrayDeque<>();
        ArrayDeque<Node<T>> otherStack = new ArrayDeque<>();

        currentStack.push(head);

        while (!currentStack.isEmpty()) {
            while (!currentStack.isEmpty()) {
                Node<T> node = currentStack.pop();
                System.out.print(node.data + " ");
                if (leftToRight) {
                    if (node.right != null) otherStack.push(node.right);
                    if (node.left != null) otherStack.push(node.left);
                } else {
                    if (node.left != null) otherStack.push(node.left);
                    if (node.right != null) otherStack.push(node.right);
                }
            }
            System.out.println();
            leftToRight = !leftToRight;
            tmpStack = currentStack;
            currentStack = otherStack;
            otherStack = tmpStack;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.solve1(ExampleTree.HEAD);
    }
}
