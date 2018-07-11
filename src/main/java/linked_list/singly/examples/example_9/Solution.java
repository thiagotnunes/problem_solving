package linked_list.singly.examples.example_9;

import linked_list.types.singly.Node;

import java.util.HashSet;

/**
 * Find the intersection of two linked lists
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n^2)
     * Space complexity - O(1)
     */
    public Node solve1(Node head1, Node head2) {
        Node current1 = head1;

        while (current1 != null) {
            Node current2 = head2;
            while (current2 != null) {
                if (current1 == current2) {
                    return current1;
                }
                current2 = current2.next;
            }
            current1 = current1.next;
        }

        return null;
    }

    /**
     * HashSet
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public Node solve2(Node head1, Node head2) {
        HashSet<Node> seen = new HashSet<>();

        Node current = head1;
        while (current != null) {
            seen.add(current);
            current = current.next;
        }

        current = head2;
        while (current != null) {
            if (seen.contains(current)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    /**
     * Iterative - length based
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public Node solve3(Node head1, Node head2) {
        int length1 = lengthOf(head1);
        int length2 = lengthOf(head2);

        Node current1 = length1 > length2 ? head1 : head2;
        Node current2 = length1 > length2 ? head2 : head1;
        int diff = Math.abs(length1 - length2);
        while (diff > 0) {
            current1 = current1.next;
            diff--;
        }

        while (current1 != current2) {
            current1 = current1.next;
            current2 = current2.next;
        }

        return current1;
    }

    private int lengthOf(Node head) {
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

        Node ten = new Node(10);
        Node eleven = new Node(11);

        one.next = two;
        two.next = three;
        three.next = four;

        ten.next = eleven;
        eleven.next = four;

        four.next = five;
        five.next = six;

        System.out.println(solution.solve3(one, ten).data);
    }
}
