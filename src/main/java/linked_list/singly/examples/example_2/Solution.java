package linked_list.singly.examples.example_2;

import linked_list.types.singly.LinkedList;
import linked_list.types.singly.Node;

/**
 * Remove duplicates from sorted linked list
 */
public class Solution {
    /**
     * Iterative
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public void solve1(Node head) {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    /**
     * Recursive
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public void solve2(Node head) {
        removeDuplicates(head);
    }

    private void removeDuplicates(Node current) {
        if (current == null || current.next == null) return;

        if (current.data == current.next.data) {
            current.next = current.next.next;
            removeDuplicates(current);
        } else {
            removeDuplicates(current.next);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        LinkedList list = new LinkedList();

        list.addLast(1);
        list.addLast(1);
        list.addLast(2);
        list.addLast(2);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(4);
        list.addLast(5);

        solution.solve1(list.getHead());

        LinkedList.print(list.getHead());
    }
}
