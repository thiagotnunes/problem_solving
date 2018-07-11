package linked_list.singly.examples.example_7;

import linked_list.types.singly.Node;

/**
 * Detect type of loop in linked list:
 * - 0 for no loop
 * - 1 for loop
 * - 2 for circular list
 */
public class Solution {
    /**
     * Iterative - slow and fast pointer
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve1(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == head) {
                return 2;
            } else if (slow == fast) {
                return 1;
            }
        }

        return 0;
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
        six.next = one;

        System.out.println(solution.solve1(one));
    }
}
