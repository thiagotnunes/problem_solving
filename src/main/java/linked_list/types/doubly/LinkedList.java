package linked_list.types.doubly;

import java.util.Iterator;

/**
 * Doubly linked list
 */
public class LinkedList implements Iterable<Integer> {
    public Node head;
    public Node tail;
    private int length;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Integer next() {
                int data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    // Time complexity - O(1)
    public void addFirst(int data) {
        Node node = new Node(data);

        node.next = head;
        if (head != null) {
            head.previous = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }
        length++;
    }

    // Time complexity - O(n)
    public void addLast(int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
            length++;
        } else {
            Node node = new Node(data);
            tail.next = node;
            node.previous = tail;
            tail = node;
            length++;
        }
    }

    // Time complexity - O(1)
    public int size() {
        return length;
    }

    // Time complexity - O(1)
    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addLast(5);
        list.addLast(4);
        list.addLast(6);
        list.addLast(3);
        list.addLast(7);
        list.addLast(8);

        for (Integer e : list) {
            System.out.println(e);
        }
    }
}
