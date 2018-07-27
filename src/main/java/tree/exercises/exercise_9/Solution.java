package tree.exercises.exercise_9;

import tree.types.binary.Node;

/**
 * Are two trees isomorphic
 */
public class Solution {
    /**
     * Time complexity - O(n + m)
     * Space complexity - O(max(heightN, heightM))
     */
    public <S,T> boolean solve1(Node<S> head1, Node<T> head2) {
        if (head1 == null && head2 == null) {
            return true;
        } else if (head1 == null || head2 == null) {
            return false;
        } else {
            return solve1(head1.left, head2.left) && solve1(head1.right, head2.right);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        Node<Integer> seven = new Node<>(7);

        two.left = one;
        two.right = three;
        six.left = five;
        six.right = seven;

        System.out.println(solution.solve1(two, six));
    }
}
