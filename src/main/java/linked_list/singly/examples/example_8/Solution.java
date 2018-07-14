package linked_list.singly.examples.example_8;

import linked_list.types.singly.LinkedList;
import linked_list.types.singly.Node;

/**
 * Remove loop from linked list
 */
public class Solution {
    /**
     * Slow and fast pointers
     * Floyd's algorithm
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public void solve1(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null) return;

        Node current = head;
        while (current.next != slow.next) {
            current = current.next;
            slow = slow.next;
        }

        slow.next = null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = three;

        solution.solve1(one);

        LinkedList.print(one);
    }
}
