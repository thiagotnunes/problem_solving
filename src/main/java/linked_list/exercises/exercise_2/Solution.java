package linked_list.exercises.exercise_2;

import linked_list.types.singly.LinkedList;
import linked_list.types.singly.Node;

/**
 * Insert an element at the kth position from the end
 * Return 1 if success and -1 if the list is not long enough
 */
public class Solution {
    /**
     * Iterative
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve1(LinkedList list, int data, int k) {
        Node slow = list.getHead();
        Node fast = list.getHead();

        k++;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }

        if (k == 1) {
            list.addFirst(data);
            return 1;
        } else if (k > 0) {
            return -1;
        } else {
            while (slow != null && fast != null) {
                slow = slow.next;
                fast = fast.next;
            }

            if (slow == null) return -1;

            Node node = new Node(data);
            Node next = slow.next;

            slow.next = node;
            node.next = next;

            return 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        LinkedList list = new LinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println(solution.solve1(list, 10, 4));
        LinkedList.print(list.getHead());
    }
}
