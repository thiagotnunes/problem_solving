package linked_list.types.singly;

import java.util.Iterator;

/**
 * Singly linked list
 */
public class LinkedList implements Iterable<Integer> {
    private Node head;
    private Node tail;
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
        Node newHead = new Node(data);
        newHead.next = head;

        head = newHead;

        if (tail == null) {
            tail = head;
        }

        length++;
    }

    // Time complexity - O(1)
    public void addLast(int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
            length++;
        } else {
            Node node = new Node(data);
            tail.next = node;
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

    public Node getHead() {
        return head;
    }

    public static void print(Node head) {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
