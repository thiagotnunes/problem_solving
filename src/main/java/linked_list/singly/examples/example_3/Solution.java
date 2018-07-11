package linked_list.singly.examples.example_3;

import linked_list.types.singly.LinkedList;
import linked_list.types.singly.Node;

/**
 * Copy a linked list reversed
 */
public class Solution {
    /**
     * Brute force - copy and then reverse
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public Node solve1(Node head) {
        Node headCopy = copy(head);

        return reverse(headCopy);
    }

    /**
     * Recursive
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public Node solve2(Node head) {
        return copyReversed(head).second;
    }

    /**
     * Iterative
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public Node solve3(Node head) {
        Node tmpNode1 = null;
        Node tmpNode2;
        Node current = head;

        while (current != null) {
            tmpNode2 = new Node(current.data, tmpNode1);
            current = current.next;
            tmpNode1 = tmpNode2;
        }

        return tmpNode1;
    }

    private class NodePair {
        public final Node first;
        public final Node second;

        public NodePair(Node first, Node second) {
            this.first = first;
            this.second = second;
        }
    }

    private NodePair copyReversed(Node current) {
        if (current.next == null) {
            Node headCopy = new Node(current.data);
            return new NodePair(headCopy, headCopy);
        }

        NodePair nodePair = copyReversed(current.next);
        nodePair.first.next = new Node(current.data);

        return new NodePair(nodePair.first.next, nodePair.second);
    }

    private Node copy(Node head) {
        if (head == null) return null;

        Node headCopy = new Node(head.data);

        Node current = head.next;
        Node currentCopy = headCopy;

        while (current != null) {
            currentCopy.next = new Node(current.data);
            current = current.next;
            currentCopy = currentCopy.next;
        }

        return headCopy;
    }

    private Node reverse(Node head) {
        Node previous = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        LinkedList list = new LinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        Node headCopy = solution.solve3(list.getHead());

        LinkedList.print(headCopy);
    }
}
