package tree.exercises.exercise_7;

import tree.bst.examples.ExampleTree;
import tree.types.binary.Node;
import util.Pair;

import java.util.ArrayDeque;

/**
 * Check if a binary tree is perfect
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

        queue.add(new Pair<>(head, 1));
        while (!queue.isEmpty()) {
            Pair<Node<T>, Integer> pair = queue.remove();
            Node<T> node = pair.first;
            int height = pair.second;

            if (height == maxHeight) {
                if (!isLeaf(node)) return false;
            } else {
                if (!hasTwoChildren(node)) return false;

                queue.add(new Pair<>(node.left, height + 1));
                queue.add(new Pair<>(node.right, height + 1));
            }
        }

        return true;
    }

    /**
     * Time complexity - O(n)
     * Space complexity - O(2^height)
     */
    @SuppressWarnings("unchecked")
    public <T> boolean solve2(Node<T> head) {
        int height;
        int size;
        T[] heap;

        height = height(head);
        size = (int) Math.pow(2, height) - 1;
        heap = (T[]) new Object[size];
        buildHeap(head, heap, 0);

        for (T e : heap) {
            if (e == null) return false;
        }

        return true;
    }

    private <T> void buildHeap(Node<T> node, T[] heap, int i) {
        if (i >= heap.length) return;

        heap[i] = node == null ? null : node.data;
        if (node != null) buildHeap(node.left, heap, (i * 2) + 1);
        if (node != null) buildHeap(node.right, heap, (i * 2) + 2);
    }

    private <T> boolean hasTwoChildren(Node<T> node) {
        return node.left != null && node.right != null;
    }

    private <T> boolean isLeaf(Node<T> node) {
        return node.left == null && node.right == null;
    }

    private <T> int height(Node<T> node) {
        if (node == null) return 0;

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve2(ExampleTree.HEAD));
    }
}
