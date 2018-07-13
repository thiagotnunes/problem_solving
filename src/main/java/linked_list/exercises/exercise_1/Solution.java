package linked_list.exercises.exercise_1;

import linked_list.types.singly.LinkedList;
import linked_list.types.singly.Node;

/**
 * Insert an element at the kth position
 * Return 1 for success, and -1 if the list is not long enough
 */
public class Solution {
    /**
     * Iterative
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve1(LinkedList list, int data, int k) {
        if (k < 0 || list.getHead() == null) {
            return -1;
        }
        if (k == 0) {
            list.addFirst(data);
            return 1;
        }

        k--;
        Node current = list.getHead();
        while (current != null && k > 0) {
            current = current.next;
            k--;
        }

        if (current == null) return -1;

        Node node = new Node(data);
        Node next = current.next;

        current.next = node;
        node.next = next;

        return 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        LinkedList list = new LinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println(solution.solve1(list, 10, 0));
        LinkedList.print(list.getHead());
    }
}
