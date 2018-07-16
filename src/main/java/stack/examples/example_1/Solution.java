package stack.examples.example_1;

import stack.types.DynamicArrayStack;
import stack.types.Stack;

/**
 * Check for balanced parenthesis
 */
public class Solution {
    public boolean solve1(String str) {
        Stack<Character> stack = new DynamicArrayStack<>();

        char[] chars = str.toCharArray();
        for (char c : chars) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != '(') return false;
                    break;
                case '}':
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != '{') return false;
                    break;
                case ']':
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != '[') return false;
                    break;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1("({[(])})"));
    }
}
