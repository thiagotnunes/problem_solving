package hash_map.examples.example_2;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove duplicates from array
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public void solve1(char[] chars) {
        Set<Character> seen = new HashSet<>();

        int i = 0;
        for (char c : chars) {
            if (!seen.contains(c)) {
                chars[i] = c;
                seen.add(c);
                i++;
            }
        }
        chars[i] = '\0';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[] chars = "abccbda".toCharArray();
        solution.solve1(chars);

        System.out.println(new String(chars));
    }
}
