package linked_list.exercises.exercise_8;

import linked_list.types.singly.LinkedList;
import linked_list.types.singly.Node;

/**
 * Find the middle element of a linked list
 */
public class Solution {
    /**
     * Length based
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public Node solve1(Node head) {
        int length = 0;
        Node current = head;
        while (current != null) {
            current = current.next;
            length++;
        }

        int i = length / 2;
        current = head;
        while (current != null && i > 0) {
            current = current.next;
            i--;
        }

        return current;
    }

    /**
     * Slow and fast pointers
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public Node solve2(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        LinkedList list = new LinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println(solution.solve2(list.getHead()).data);
    }
}
