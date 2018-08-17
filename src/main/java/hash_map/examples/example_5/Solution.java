package hash_map.examples.example_5;

import hash_map.types.CountMap;

/**
 * Print the first repeating number
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public void solve1(int[] array) {
        CountMap<Integer> seen = new CountMap<>();
        for (int e : array) {
            seen.add(e);
        }

        for (int e : array) {
            if (seen.get(e) > 1) {
                System.out.println(e);
                return;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.solve1(new int[]{1, 2, 3, 2, 1});
    }
}
