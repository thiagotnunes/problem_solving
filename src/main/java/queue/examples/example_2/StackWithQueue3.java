package queue.examples.example_2;

import queue.types.LinkedListQueue;
import queue.types.Queue;
import stack.types.Stack;

/**
 * Implement stack with queues
 *
 * Push time complexity - O(n)
 * Pop time complexity - O(1)
 */
public class StackWithQueue3 implements Stack<Integer> {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackWithQueue3() {
        this.queue1 = new LinkedListQueue<>();
        this.queue2 = new LinkedListQueue<>();
    }

    @Override
    public void push(Integer e) {
        queue2.add(e);

        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    @Override
    public Integer pop() {
        if (queue1.isEmpty()) throw new RuntimeException("Stack is empty");

        return queue1.remove();
    }

    @Override
    public Integer top() {
        if (queue1.isEmpty()) throw new RuntimeException("Stack is empty");

        return queue1.peek();
    }

    @Override
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    @Override
    public int size() {
        return queue1.size();
    }
}
