package queue.examples.example_4;

import queue.types.LinkedListQueue;
import queue.types.Queue;
import stack.types.DynamicArrayStack;
import stack.types.Stack;

/**
 * Reverse a queue
 */
public class Solution {
    /**
     * Using a stack
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public void solve1(Queue<Integer> queue) {
        Stack<Integer> stack = new DynamicArrayStack<>();

        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Queue<Integer> queue = new LinkedListQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        solution.solve1(queue);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}
