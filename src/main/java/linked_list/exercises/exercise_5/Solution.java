package linked_list.exercises.exercise_5;

import linked_list.types.singly.Node;

import java.util.HashSet;

/**
 * When a linked list with a loop is given, return the number
 * of nodes in the list
 */
public class Solution {
    /**
     * HashSet
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public int solve1(Node head) {
        HashSet<Node> seen = new HashSet<>();
        Node current = head;
        int count = 0;

        while (current != null) {
            if (seen.contains(current)) {
                break;
            } else {
                seen.add(current);
            }
            current = current.next;
            count++;
        }

        return count;
    }

    /**
     * Floyd's algorithm
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve2(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast != null) {
            Node current = head;
            while (current.next != slow.next) {
                current = current.next;
                slow = slow.next;
            }
            slow.next = null;
        }

        int length = 0;
        Node current = head;
        while (current != null) {
            current = current.next;
            length++;
        }

        return length;
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

        System.out.println(solution.solve2(one));
    }
}
