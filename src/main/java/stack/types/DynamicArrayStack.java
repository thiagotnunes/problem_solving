package stack.types;

import java.util.ArrayList;

public class DynamicArrayStack implements Stack<Integer> {
    private int top;
    private ArrayList<Integer> stack;

    public DynamicArrayStack() {
        this.top = -1;
        this.stack = new ArrayList<>();
    }

    @Override
    public void push(Integer e) {
        stack.add(++top, e);
    }

    @Override
    public Integer pop() {
        if (top < 0) throw new RuntimeException("Stack is empty");

        return stack.get(top--);
    }

    @Override
    public Integer top() {
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
