package queue.types;

public class LinkedListQueue<T> implements Queue<T> {
    private class QueueNode {
        public final T data;
        public QueueNode next;

        QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode front;
    private QueueNode back;
    private int length;

    @Override
    public void add(T e) {
        QueueNode node = new QueueNode(e);
        if (front == null) {
            front = node;
            back = node;
        } else {
            back.next = node;
            back = node;
        }
        length++;
    }

    @Override
    public T peek() {
        if (front == null) throw new RuntimeException("Queue is empty");

        return front.data;
    }

    @Override
    public T remove() {
        if (front == null) throw new RuntimeException("Queue is empty");

        T e = front.data;
        front = front.next;
        length--;

        return e;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int size() {
        return length;
    }
}
