package tree.binary.examples.example_16;

import tree.binary.examples.ExampleTree;
import tree.types.binary.Node;

/**
 * Least common ancestor
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n) (for the system stack)
     */
    public <T> Node<T> solve1(Node<T> current, T value1, T value2) {
        if (current == null) return null;
        if (current.data.equals(value1) || current.data.equals(value2)) return current;

        Node<T> leftNode = solve1(current.left, value1, value2);
        Node<T> rightNode = solve1(current.right, value1, value2);

        if (leftNode != null && rightNode != null) {
            return current;
        } else if (leftNode != null) {
            return leftNode;
        } else {
            return rightNode;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(ExampleTree.HEAD, 3, 6).data);
    }
}
