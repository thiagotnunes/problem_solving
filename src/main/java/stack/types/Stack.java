package stack.types;

public interface Stack<T> {
    void push(T e);
    T pop();
    T top();
    boolean isEmpty();
    int size();
}
