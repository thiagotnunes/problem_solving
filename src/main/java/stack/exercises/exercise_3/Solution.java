package stack.exercises.exercise_3;

import java.util.ArrayDeque;

/**
 * HTML opening and closing tag parser
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public boolean solve1(String[] tags) {
        int n = tags.length;
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < n / 2; i++) {
            String tag = tags[i].replaceAll("[<|>|/]", "");
            stack.push(tag);
        }

        for (int i = n / 2; i < n; i++) {
            String popped = stack.pop();
            String tag = tags[i].replaceAll("[<|>|/]", "");
            if (!popped.equals(tag)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        boolean result = solution.solve1(new String[]{"<html>", "<body>", "</html>", "</body>"});

        System.out.println(result);
    }
}
