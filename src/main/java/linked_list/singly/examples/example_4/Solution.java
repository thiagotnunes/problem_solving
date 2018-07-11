package linked_list.singly.examples.example_4;

import linked_list.types.singly.LinkedList;
import linked_list.types.singly.Node;

/**
 * Kth node from the beginning
 */
public class Solution {
    /**
     * Iterative
     * Time complexity - O(k)
     * Space complexity - O(1)
     */
    public Node solve1(Node head, int k) {
        Node current = head;
        k--;
        while (current != null && k > 0) {
            current = current.next;
            k--;
        }

        return current;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        LinkedList list = new LinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        Node node = solution.solve1(list.getHead(), 5);

        System.out.println(node.data);
    }
}
