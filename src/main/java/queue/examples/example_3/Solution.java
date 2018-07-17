package queue.examples.example_3;

import queue.types.LinkedListQueue;
import queue.types.Queue;
import stack.types.DynamicArrayStack;
import stack.types.Stack;

/**
 * Reverse a stack
 */
public class Solution {
    /**
     * Using a queue
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public void solve1(Stack<Integer> stack) {
        Queue<Integer> queue = new LinkedListQueue<>();

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Stack<Integer> stack = new DynamicArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        solution.solve1(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
