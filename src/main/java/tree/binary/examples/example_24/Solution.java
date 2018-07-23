package tree.binary.examples.example_24;

import tree.binary.examples.ExampleTree;
import tree.types.binary.Node;
import util.Pair;

import java.util.ArrayDeque;
import java.util.function.Consumer;

/**
 * Iterative in-order
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public <T> void solve1(Node<T> node, Consumer<T> f) {
        ArrayDeque<Pair<Node<T>, Boolean>> stack = new ArrayDeque<>();
        stack.push(new Pair<>(node, false));

        while (!stack.isEmpty()) {
            Pair<Node<T>, Boolean> pair = stack.pop();
            Node<T> current = pair.first;
            Boolean processed = pair.second;

            if (!processed) {
                if (current.right != null) stack.push(new Pair<>(current.right, false));
                pair.second = true;
                stack.push(pair);
                if (current.left != null) stack.push(new Pair<>(current.left, false));
            } else {
                f.accept(current.data);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.solve1(ExampleTree.HEAD, System.out::println);
    }
}
