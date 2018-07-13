package linked_list.doubly.examples.example_2;

import linked_list.types.doubly.LinkedList;
import linked_list.types.doubly.Node;

/**
 * Copy the list reversed
 */
public class Solution {
    /**
     * Iterative solution
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public Node solve1(Node head) {
        Node current = head;
        Node newHead = null;

        while (current != null) {
            Node node = new Node(current.data);
            node.next = newHead;
            if (newHead != null) newHead.previous = node;
            newHead = node;
            current = current.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        LinkedList list = new LinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        Node node = solution.solve1(list.getHead());

        LinkedList.print(node);
    }
}
