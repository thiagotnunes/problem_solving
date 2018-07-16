package stack.examples.example_3;

import stack.types.DynamicArrayStack;

/**
 * Find out if a string is a palindrome using a stack
 */
public class Solution {
    /**
     * Stack
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public boolean solve1(String str) {
        DynamicArrayStack<Character> stack = new DynamicArrayStack<>();
        char[] chars = str.toCharArray();
        int length = chars.length;

        for (int i = 0; i < length / 2; i++) {
            stack.push(chars[i]);
        }

        int start = length % 2 == 0 ? length / 2 : length / 2 + 1;
        for (int i = start; i < length; i++) {
            Character c = stack.pop();
            if (c != chars[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1("abccba"));
    }
}
