package queue.examples.example_2;

import queue.types.LinkedListQueue;
import queue.types.Queue;
import stack.types.Stack;

/**
 * Implement a stack with queues
 *
 * Uses two queues and iterates until last element for pop and top
 * Push time complexity - O(1)
 * Pop time complexity - O(n)
 */
public class StackWithQueue1 implements Stack<Integer> {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackWithQueue1() {
        this.queue1 = new LinkedListQueue<>();
        this.queue2 = new LinkedListQueue<>();
    }

    @Override
    public void push(Integer e) {
        queue1.add(e);
    }

    /**
     * Time complexity - O(n)
     */
    @Override
    public Integer pop() {
        if (queue1.isEmpty()) throw new RuntimeException("Stack is empty");

        int size = queue1.size() - 1;
        for (int i = 0; i < size; i++) {
            queue2.add(queue1.remove());
        }

        Integer e = queue1.remove();
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;

        return e;
    }

    /**
     * Time complexity - O(n)
     */
    @Override
    public Integer top() {
        if (queue1.isEmpty()) throw new RuntimeException("Stack is empty");

        int size = queue1.size() - 1;
        for (int i = 0; i < size; i++) {
            queue2.add(queue1.remove());
        }
        Integer e = queue1.remove();
        queue2.add(e);
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;

        return e;
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
