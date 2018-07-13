package stack.types;

public class ArrayStack implements Stack<Integer> {
    private final int capacity;
    private int top;
    private Integer[] stack;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.stack = new Integer[capacity + 1];
        this.top = -1;
    }

    @Override
    public void push(Integer e) {
        if (top >= capacity - 1) throw new RuntimeException("Stack is full");

        stack[++top] = e;
    }

    @Override
    public Integer pop() {
        if (top < 0) throw new RuntimeException("Stack is empty");

        Integer e = stack[top--];

        return e;
    }

    @Override
    public Integer top() {
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
