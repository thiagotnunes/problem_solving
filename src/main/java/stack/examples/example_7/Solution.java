package stack.examples.example_7;

import stack.types.DynamicArrayStack;

/**
 * Convert infix expression to postfix expression
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public String solve1(String expression) {
        char[] chars = expression.toCharArray();
        StringBuilder output = new StringBuilder();
        DynamicArrayStack<Character> stack = new DynamicArrayStack<>();

        for (char c : chars) {
            switch (c) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    output.append(c);
                    output.append(' ');
                    break;
                case '-':
                case '+':
                case '*':
                case '/':
                case '^':
                case '%':
                    while (!stack.isEmpty() && stack.top() != '(' && precedence(c) <= precedence(stack.top())) {
                        output.append(stack.pop());
                        output.append(' ');
                    }
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    char op = stack.pop();
                    while (!stack.isEmpty() && op != '(') {
                        output.append(op);
                        output.append(' ');
                        op = stack.pop();
                    }
                    break;
                default: // NoOp
            }
        }
        while (!stack.isEmpty()) {
            output.append(stack.pop());
            output.append(' ');
        }

        return output.toString();
    }

    private int precedence(Character operand) {
        switch (operand) {
            case '-':
                return 0;
            case '+':
                return 0;
            case '*':
                return 1;
            case '/':
                return 1;
            case '^':
                return 2;
            case '%':
                return 2;
            default:
                throw new RuntimeException("Illegal operand " + operand);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1("(1 + 2) * 3"));
    }
}
