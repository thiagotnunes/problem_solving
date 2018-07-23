package tree.binary.examples.example_23;

import tree.binary.examples.ExampleTree;
import tree.types.binary.BinaryTree;
import tree.types.binary.Node;
import util.Pair;

import java.util.ArrayDeque;
import java.util.function.Consumer;

/**
 * Iterative post-order
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public <T> void solve1(Node<T> node, Consumer<T> f) {
        ArrayDeque<Pair<Node<T>, Boolean>> stack = new ArrayDeque<>();
        stack.push(new Pair(node, false));

        while (!stack.isEmpty()) {
            Pair<Node<T>, Boolean> pair = stack.peek();
            Node<T> current = pair.first;
            Boolean processed = pair.second;
            if (!processed) {
                pair.second = true;
                if (current.right != null) stack.push(new Pair<>(current.right, false));
                if (current.left != null) stack.push(new Pair<>(current.left, false));
            } else {
                f.accept(stack.pop().first.data);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        BinaryTree.postOrder(ExampleTree.HEAD, System.out::println);
        System.out.println("-----");
        solution.solve1(ExampleTree.HEAD, System.out::println);
    }
}
