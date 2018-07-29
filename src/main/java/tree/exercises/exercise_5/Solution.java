package tree.exercises.exercise_5;

import tree.bst.examples.ExampleTree;
import tree.types.binary.Node;
import util.Pair;

import java.util.ArrayDeque;

/**
 * Check if a binary tree is complete
 */
public class Solution {
    /**
     * BFS
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public <T> boolean solve1(Node<T> head) {
        ArrayDeque<Pair<Node<T>, Integer>> queue = new ArrayDeque<>();
        int maxHeight = height(head);
        boolean leftSiblingHasTwoChildren = true;

        queue.addFirst(new Pair<>(head, 1));
        while (!queue.isEmpty()) {
            Pair<Node<T>, Integer> pair = queue.remove();
            Node<T> node = pair.first;
            int height = pair.second;

            if (height < maxHeight - 1) {
                if (hasTwoChildren(node)) {
                    queue.add(new Pair<>(node.left, height + 1));
                    queue.add(new Pair<>(node.right, height + 1));
                } else {
                    return false;
                }
            } else if (height == maxHeight - 1) {
                if (hasTwoChildren(node) && leftSiblingHasTwoChildren) {
                    queue.add(new Pair<>(node.left, height + 1));
                    queue.add(new Pair<>(node.right, height + 1));
                } else if (hasLeftChild(node) && leftSiblingHasTwoChildren) {
                    leftSiblingHasTwoChildren = false;
                } else if (hasNoChildren(node)) {
                    leftSiblingHasTwoChildren = false;
                } else {
                    return false;
                }
            } else {
                if (!hasNoChildren(node)) return false;
            }
        }

        return true;
    }

    /**
     * Heap checking for nulls
     * Time complexity - O(n)
     * Space complexity - O(2^height)
     */
    @SuppressWarnings("unchecked")
    public <T> boolean solve2(Node<T> node) {
        int size;
        T[] heap;

        size = (int) Math.pow(2, height(node)) - 1;
        heap = (T[]) new Object[size];
        buildHeap(node, heap, 0);

        for (int i = 1; i < heap.length - 1; i++) {
            if (heap[i - 1] != null && heap[i] == null && heap[i + 1] != null) return false;
        }

        return true;
    }


    private <T> void buildHeap(Node<T> node, T[] heap, int i) {
        if (i >= heap.length) return;

        heap[i] = node == null ? null : node.data;
        if (node != null) buildHeap(node.left, heap, (i * 2) + 1);
        if (node != null) buildHeap(node.right, heap, (i * 2) + 2);
    }

    private <T> int height(Node<T> node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private <T> boolean hasTwoChildren(Node<T> node) {
        return node.left != null && node.right != null;
    }

    private <T> boolean hasLeftChild(Node<T> node) {
        return (node.left != null && node.right == null);
    }

    private <T> boolean hasNoChildren(Node<T> node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve2(ExampleTree.HEAD));
    }
}
