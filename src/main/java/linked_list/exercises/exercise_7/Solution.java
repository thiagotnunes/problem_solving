package linked_list.exercises.exercise_7;

import linked_list.types.singly.LinkedList;
import linked_list.types.singly.Node;

/**
 * Given two linked lists find out if one is the reverse of another
 * Only one pass in the lists is allowed
 */
public class Solution {
    private class Result {
        private final Boolean equal;
        private final Node second;

        public Result(Boolean equal, Node second) {
            this.equal = equal;
            this.second = second;
        }
    }

    /**
     * Brute force
     * Time complexity - O(n^2)
     * Space complexity - O(1)
     */
    public Boolean solve1(Node head1, Node head2) {
        int n = lengthOf(head1);
        int m = lengthOf(head2);

        if (n != m) return false;

        Node current1 = head1;
        Node current2;
        while (current1 != null) {
            current2 = kth(head2, n - 1);

            if (current1.data == current2.data) {
                current1 = current1.next;
                n--;
            } else {
                return false;
            }
        }

        return true;
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

    private Node kth(Node head, int k) {
        int i = 0;
        while (head != null && i < k) {
            head = head.next;
            i++;
        }
        return head;
    }

    /**
     * Recursive
     * Time complexity - O(n)
     * Space complexity - O(n) (for the system stack)
     */
    public Boolean solve2(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return true;
        } else if (head1 == null || head2 == null) {
            return false;
        }
        return isReverseOf(head1, head2).equal;
    }

    private Result isReverseOf(Node head1, Node head2) {
        if (head1.next == null) return new Result(head1.data == head2.data, head2);

        Result result = isReverseOf(head1.next, head2);
        Node next = result.second != null ? result.second.next : null;
        Boolean equal = next != null && next.data == head1.data;
        return new Result(result.equal && equal, next);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);

        list2.addLast(5);
        list2.addLast(4);
        list2.addLast(3);
        list2.addLast(2);
        list2.addLast(1);

        System.out.println(solution.solve1(list1.getHead(), list2.getHead()));
    }
}
