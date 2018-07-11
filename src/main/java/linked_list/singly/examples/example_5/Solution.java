package linked_list.singly.examples.example_5;

import linked_list.types.singly.LinkedList;
import linked_list.types.singly.Node;

/**
 * Kth node from the end
 */
public class Solution {
    /**
     * Iterative - slow and fast pointers
     * Time complexity - O(n + k)
     * Space complexity - O(1)
     */
    public Node solve1(Node head, int k) {
        Node slow = head;
        Node fast = head;

        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }

        while (fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return k <= 0 ? slow : null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        LinkedList list = new LinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        Node node = solution.solve1(list.getHead(), 1);

        System.out.println(node.data);
    }
}
