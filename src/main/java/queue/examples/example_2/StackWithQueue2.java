package queue.examples.example_2;

import queue.types.LinkedListQueue;
import stack.types.Stack;

/**
 * Implement stack with queues
 *
 * Uses single queue
 * Push time complexity - O(1)
 * Pop time complexity - O(n)
 */
public class StackWithQueue2 implements Stack<Integer> {
    private final LinkedListQueue<Integer> queue;

    public StackWithQueue2() {
        this.queue = new LinkedListQueue<Integer>();
    }

    @Override
    public void push(Integer e) {
        queue.add(e);
    }

    @Override
    public Integer pop() {
        if (queue.isEmpty()) throw new RuntimeException("Stack is empty");

        int size = queue.size() - 1;
        for (int i = 0; i < size; i++) {
            queue.add(queue.remove());
        }

        return queue.remove();
    }

    @Override
    public Integer top() {
        Integer e = pop();

        queue.add(e);

        return e;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }
}
