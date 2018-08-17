package hash_map.examples.example_3;

import java.util.HashSet;

/**
 * Find the missing int in the array
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public int solve1(int[] array, int from, int to) {
        HashSet<Integer> seen = new HashSet<>();

        for (int e : array) {
            seen.add(e);
        }

        for (int i = from; i <= to; i++) {
            if (!seen.contains(i)) {
                return i;
            }
        }

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(new int[]{1, 2, 3, 4, 6, 7, 8}, 1, 8));
    }
}
