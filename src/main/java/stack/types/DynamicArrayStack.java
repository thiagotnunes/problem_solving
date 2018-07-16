package stack.types;

import java.util.ArrayList;

public class DynamicArrayStack<T> implements Stack<T> {
    private int top;
    private ArrayList<T> stack;

    public DynamicArrayStack() {
        this.top = -1;
        this.stack = new ArrayList<>();
    }

    @Override
    public void push(T e) {
        stack.add(++top, e);
    }

    @Override
    public T pop() {
        if (top < 0) throw new RuntimeException("Stack is empty");

        return stack.get(top--);
    }

    @Override
    public T top() {
        if (top < 0) throw new RuntimeException("Stack is empty");

        return stack.get(top);
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
