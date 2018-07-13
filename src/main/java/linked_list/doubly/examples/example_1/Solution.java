package linked_list.doubly.examples.example_1;

import linked_list.types.doubly.LinkedList;
import linked_list.types.doubly.Node;

/**
 * Reverse a doubly linked list
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
            previous = current.previous;
            next = current.next;

            current.previous = next;
            current.next = previous;
            previous = current; // this is just to return the new head
            current = next;
        }

        return previous;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        LinkedList list = new LinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        Node node = solution.solve1(list.getHead());

        LinkedList.print(node);
    }
}
