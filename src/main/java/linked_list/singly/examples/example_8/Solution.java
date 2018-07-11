package linked_list.singly.examples.example_8;

import linked_list.types.singly.LinkedList;
import linked_list.types.singly.Node;

/**
 * Remove loop from linked list
 * TODO: Implement, find the beginning of the loop
 */
public class Solution {
    public void solve1(Node head) {}

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

        solution.solve1(one);

        LinkedList.print(one);
    }
}
