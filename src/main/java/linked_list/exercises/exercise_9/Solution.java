package linked_list.exercises.exercise_9;

import linked_list.types.singly.LinkedList;
import linked_list.types.singly.Node;

/**
 * Print the list in reversed order
 */
public class Solution {
    /**
     * Length based
     * Time complexity - O(n^2)
     * Space complexity - O(1)
     */
    public void solve1(Node head) {
        int length = 0;
        Node current = head;
        while (current != null) {
            current = current.next;
            length++;
        }

        while (length > 0) {
            int i = 0;
            Node current2 = head;
            while (i < length - 1) {
                current2 = current2.next;
                i++;
            }
            System.out.println(current2.data);
            length--;
        }
    }

    /**
     * Recursive
     * Time complexity - O(n)
     * Space complexity - O(n) (for the system stack)
     */
    public void solve2(Node head) {
        if (head == null) return;

        solve2(head.next);

        System.out.println(head.data);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        LinkedList list = new LinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        solution.solve2(list.getHead());
    }
}
