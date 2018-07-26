package tree.bst.examples;

import tree.types.binary.Node;

public class ExampleTree {
    /**
     *        4
     *     2     6
     *    1 3   5 7
     */
    public final static Node<Integer> HEAD;

    static {
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        Node<Integer> seven = new Node<>(7);

        four.left = two;
        four.right = six;
        two.left = one;
        two.right = three;
        six.left = five;
        six.right = seven;

        HEAD = four;
    }
}
