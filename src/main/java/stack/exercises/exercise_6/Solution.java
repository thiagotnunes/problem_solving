package stack.exercises.exercise_6;

import java.util.ArrayDeque;

/**
 * Palindrome matching function for alpha numeric digits
 */
public class Solution {
    /**
     * Char comparison from beginning and end
     * Time complexity - O(n) ??? TODO: Figure out time complexity of replace all
     * Space complexity - O(n)
     */
    public boolean solve1(String str) {
        String alphaNumeric = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for (int i = 0; i < alphaNumeric.length() / 2; i++) {
            int hi = alphaNumeric.length() - i - 1;
            if (alphaNumeric.charAt(i) != alphaNumeric.charAt(hi)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Stack based
     * Time complexity - O(n) ??? TODO: Figure out time complexity of replaceAll
     * Space complexity - O(n)
     */
    public boolean solve2(String str) {
        String alphaNumeric = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int length = alphaNumeric.length();

        for (int i = 0; i < length / 2; i++) {
            stack.push(alphaNumeric.charAt(i));
        }

        int start = length % 2 == 0 ? length / 2 : length / 2 + 1;
        for (int i = start; i < length; i++) {
            if (stack.pop() != alphaNumeric.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Letter or digit counting
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public boolean solve3(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int alphaNumericCount = 0;

        for (char c : chars) {
            if (isAlphaNumeric(c)) {
                alphaNumericCount++;
            }
        }

        int i = 0;
        int k = 0;
        for (; i < n; i++) {
            char c = chars[i];
            if (k >= alphaNumericCount / 2)
                break;

            if (isAlphaNumeric(c)) {
                stack.push(Character.toLowerCase(c));
                k++;
            }
        }

        boolean ignoreFirst = k % 2 != 0;
        for (; i < n; i++) {
            char c = chars[i];
            if (isAlphaNumeric(c)) {
                if (ignoreFirst) {
                    ignoreFirst = false;
                } else if (Character.toLowerCase(c) != stack.pop()) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return (c >= '0' && c <= '9') ||
                (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z');
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve3("Madam, I'm Adam"));
    }
}
