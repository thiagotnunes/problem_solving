package queue.types;

public class ArrayQueue<T> implements Queue<T> {

    private int capacity;
    private T[] queue;
    private int front;
    private int back;
    private int length;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
        front = 0;
        back = 0;
        length = 0;
    }

    @Override
    public void add(T e) {
        if (queue[back] != null) throw new RuntimeException("Queue is full");

        queue[back] = e;
        back = (back + 1) % capacity;
        length++;
    }

    @Override
    public T peek() {
        if (queue[front] == null) throw new RuntimeException("Queue is empty");

        return queue[front];
    }

    @Override
    public T remove() {
        if (queue[front] == null) throw new RuntimeException("Queue is empty");

        T e = queue[front];
        queue[front] = null;
        front = (front + 1) % capacity;
        length--;

        return e;
    }

    @Override
    public boolean isEmpty() {
        return queue[front] == null;
    }

    @Override
    public int size() {
        return length;
    }
}
