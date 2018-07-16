package stack.exercises.exercise_2;

import java.util.ArrayDeque;

/**
 * Convert infix expression to prefix expression
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public void solve1(char[] chars) {
        reverse(chars); // O(n)
        replaceParenthesis(chars); // O(n)
        infixToPostfix(chars); // O(n)
        reverse(chars); // O(n)
    }

    private void infixToPostfix(char[] chars) {
        int n = chars.length;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] output = new char[n];

        int k = 0;
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
                    output[k++] = c;
                    break;
                case '+':
                case '-':
                case '/':
                case '*':
                case '^':
                case '%':
                    while (!stack.isEmpty() && stack.peek() != '(' && (precedence(c) <= precedence(stack.peek()))) {
                        output[k++] = stack.pop();
                    }
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    char op = stack.pop();
                    while (!stack.isEmpty() && op != '(') {
                        output[k++] = op;
                        op = stack.pop();
                    }
                    break;
            }
        }

        while (!stack.isEmpty()) {
            output[k++] = stack.pop();
        }

        System.arraycopy(output, 0, chars, 0, n);
    }

    private int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 0;
            case '*':
            case '/':
                return 1;
            case '%':
            case '^':
                return 2;
            default:
                throw new RuntimeException("Unknown operator " + c);
        }
    }

    private void replaceParenthesis(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                chars[i] = ')';
            } else if (chars[i] == ')') {
                chars[i] = '(';
            }
        }
    }

    private void reverse(char[] chars) {
        int n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            int hi = n - i - 1;
            char c = chars[i];
            chars[i] = chars[hi];
            chars[hi] = c;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[] chars = "1+2+3*4-(6^2)".toCharArray();
        solution.solve1(chars);

        System.out.println(chars);
    }
}
