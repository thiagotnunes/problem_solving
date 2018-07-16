package stack.types;

public class ArrayStack<T> implements Stack<T> {
    private final int capacity;
    private int top;
    private T[] stack;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.stack = (T[]) new Object[capacity + 1];
        this.top = -1;
    }

    @Override
    public void push(T e) {
        if (top >= capacity - 1) throw new RuntimeException("Stack is full");

        stack[++top] = e;
    }

    @Override
    public T pop() {
        if (top < 0) throw new RuntimeException("Stack is empty");

        return stack[top--];
    }

    @Override
    public T top() {
        if (top < 0) throw new RuntimeException("Stack is empty");

        return stack[top];
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
