package linked_list.singly.examples.example_1;

import linked_list.types.singly.LinkedList;
import linked_list.types.singly.Node;

/**
 * Reverse a linked list
 */
public class Solution {
    /**
     * Iterative
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public Node solve1(Node head) {
        Node previous = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }

        return previous;
    }

    /**
     * Recursive
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public Node solve2(Node head) {
        return reverse(null, head, null);
    }

    private Node reverse(Node previous, Node current, Node next) {
        if (current == null) return previous;

        next = current.next;
        current.next = previous;
        previous = current;
        current = next;

        return reverse(previous, current, next);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        LinkedList list = new LinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        Node head = solution.solve2(list.getHead());

        LinkedList.print(head);
    }
}
