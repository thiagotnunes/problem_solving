package stack.examples.example_2;

import stack.types.Stack;

import java.util.ArrayList;

/**
 * Design a stack to keep the minimum value in O(1)
 */
public class Solution {
    private static class StackNode {
        public final int data;
        public final int min;

        public StackNode(int data, int min) {
            this.data = data;
            this.min = min;
        }
    }

    private static class MinStack implements Stack<Integer> {
        private int top;
        private ArrayList<StackNode> stack;

        public MinStack() {
            stack = new ArrayList<>();
            top = -1;
        }

        public Integer min() {
            if (top < 0) throw new RuntimeException("Stack is empty");

            return stack.get(top).min;
        }

        @Override
        public void push(Integer e) {
            int min;
            if (top < 0) {
                min = e;
            } else {
                min = Math.min(min(), e);
            }

            stack.add(++top, new StackNode(e, min));
        }

        @Override
        public Integer pop() {
            if (top < 0) throw new RuntimeException("stack is empty");

            return stack.get(top--).data;
        }

        @Override
        public Integer top() {
            if (top < 0) throw new RuntimeException("stack is empty");

            return stack.get(top).data;
        }

        @Override
        public boolean isEmpty() {
            return top < 0;
        }

        @Override
        public int size() {
            return top + 1;
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(5);
        stack.push(4);
        stack.push(6);
        stack.pop();
        stack.pop();
        System.out.println(stack.min());
    }
}
