package stack.examples.example_4;

import stack.types.DynamicArrayStack;
import stack.types.Stack;

/**
 * Reverse a stack without using any other data structures
 */
public class Solution {
    /**
     * Time complexity - O(n^2)
     * Space complexity - O(n) (for the system stack)
     */
    public void solve1(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        Integer e = stack.pop();
        solve1(stack);
        insertAtBottom(stack, e);
    }

    private void insertAtBottom(Stack<Integer> stack, Integer value) {
        if (stack.isEmpty()) {
            stack.push(value);
        } else {
            Integer e = stack.pop();
            insertAtBottom(stack, value);
            stack.push(e);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        DynamicArrayStack<Integer> stack = new DynamicArrayStack<>();

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
