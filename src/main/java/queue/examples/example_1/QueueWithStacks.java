package queue.examples.example_1;

import queue.types.Queue;

import java.util.ArrayDeque;

/**
 * Implement a queue using stacks
 *
 * Add time complexity - O(1)
 * Remove time complexity - O(n)
 */
public class QueueWithStacks implements Queue<Integer> {
    private ArrayDeque<Integer> stack1;
    private ArrayDeque<Integer> stack2;

    public QueueWithStacks() {
        this.stack1 = new ArrayDeque<>();
        this.stack2 = new ArrayDeque<>();
    }


    @Override
    public void add(Integer e) {
        stack1.push(e);
    }

    @Override
    public Integer peek() {
        if (stack1.isEmpty() && stack2.isEmpty()) throw new RuntimeException("Stack is empty");

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    @Override
    public Integer remove() {
        if (stack1.isEmpty() && stack2.isEmpty()) throw new RuntimeException("Stack is empty");

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public int size() {
        return stack1.size() + stack2.size();
    }
}
