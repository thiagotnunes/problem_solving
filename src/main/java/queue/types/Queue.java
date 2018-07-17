package queue.types;

public interface Queue<T> {
    void add(T e);

    T remove();

    T peek();

    boolean isEmpty();

    int size();
}
