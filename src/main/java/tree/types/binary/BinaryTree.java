package tree.types.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTree {
    public static <T> void inOrder(Node<T> node, Consumer<T> f) {
        if (node == null) return;

        inOrder(node.left, f);
        f.accept(node.data);
        inOrder(node.right, f);
    }

    public static <T> void preOrder(Node<T> node, Consumer<T> f) {
        if (node == null) return;

        f.accept(node.data);
        preOrder(node.left, f);
        preOrder(node.right, f);
    }

    public static <T> void postOrder(Node<T> node, Consumer<T> f) {
        if (node == null) return;

        postOrder(node.left, f);
        postOrder(node.right, f);
        f.accept(node.data);
    }

    public static <T> void printInOrder(Node<T> node) {
        inOrder(node, System.out::println);
    }

    public static <T> void print(Node<T> node) {
        List<List<Node<T>>> nodesByLevel = nodesByLevel(node);
        for (List<Node<T>> nodesInLevel : nodesByLevel) {
            for (Node<T> aNodesInLevel : nodesInLevel) {
                System.out.print(aNodesInLevel.data + " ");
            }
            System.out.println();
        }
    }

    private static <T> List<List<Node<T>>> nodesByLevel(Node<T> node) {
        List<List<Node<T>>> nodesByLevel = new ArrayList<>();
        List<Node<T>> nodesInLevel = new ArrayList<>();
        nodesInLevel.add(node);
        nodesByLevel.add(nodesInLevel);

        int i = 0;
        while (i <= nodesByLevel.size() - 1) {
            nodesInLevel = nodesByLevel.get(i);

            List<Node<T>> newLevel = new ArrayList<>();
            for (Node<T> current : nodesInLevel) {
                if (current != null && current.left != null) {
                    newLevel.add(current.left);
                }
                if (current != null && current.right != null) {
                    newLevel.add(current.right);
                }
            }
            if (!newLevel.isEmpty()) {
                nodesByLevel.add(newLevel);
            }
            i++;
        }

        return nodesByLevel;
    }

    public static void main(String[] args) {
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

        print(four);
    }
}
