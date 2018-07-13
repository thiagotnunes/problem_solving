package stack.types;

import linked_list.types.singly.Node;

public class LinkedListStack implements Stack<Integer> {
    private Node head;
    private int length;

    @Override
    public void push(Integer e) {
        Node node = new Node(e);

        if (head == null) {
            head = node;
        } else {
            head.next = node;
            head = node;
        }
        length++;
    }

    @Override
    public Integer pop() {
        if (head == null) throw new RuntimeException("Stack is empty");

        Integer e = head.data;
        head = head.next;
        length--;

        return e;
    }

    @Override
    public Integer top() {
        if (head == null) throw new RuntimeException("Stack is empty");

        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return length;
    }
}
