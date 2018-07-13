package linked_list.exercises.exercise_4;

import linked_list.types.singly.LinkedList;
import linked_list.types.singly.Node;

/**
 * Find the number of occurrences of a given number
 */
public class Solution {
    /**
     * Iterative
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve1(Node head, int e) {
        int count = 0;
        Node current = head;

        while (current != null) {
            if (current.data == e) {
                count++;
            }
            current = current.next;
        }

        return count;
    }

    /**
     * Recursive
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve2(Node head, int e) {
        return solve2(head, e, 0);
    }

    private int solve2(Node head, int e, int count) {
        if (head == null) return count;

        return solve2(head.next, e, head.data == e ? count + 1 : count);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        LinkedList list = new LinkedList();

        list.addLast(3);
        list.addLast(1);
        list.addLast(3);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(3);

        System.out.println(solution.solve2(list.getHead(), 3));
    }
}
