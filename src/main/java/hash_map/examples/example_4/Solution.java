package hash_map.examples.example_4;

import java.util.HashSet;

/**
 * Print the repeating integer in an array
 */
public class Solution {

    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public void solve1(int[] array) {
        HashSet<Object> seen = new HashSet<>();

        for (int e : array) {
            if (seen.contains(e)) {
                System.out.println(e);
            } else {
                seen.add(e);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.solve1(new int[]{1, 2, 3, 4, 5, 2, 5, 1});
    }
}
