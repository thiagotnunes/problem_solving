package linked_list.singly.examples.example_6;

import linked_list.types.singly.Node;

/**
 * Detect loop in linked list
 */
public class Solution {
    /**
     * Iterative - slow and fast pointers
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public boolean solve1(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
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
        six.next = four;

        System.out.println(solution.solve1(one));
    }
}
