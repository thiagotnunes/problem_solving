package searching.problems.exercise_17;

import java.util.HashMap;

/**
 * Find first repeated element in an unsorted array
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n^2)
     * Space complexity - O(1)
     */
    public int solve1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int e = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (e == array[j]) return e;
            }
        }

        return Integer.MIN_VALUE;
    }

    /**
     * HashMap
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public int solve2(int[] array) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int e : array) {
            counts.compute(e, (key, value) -> value == null ? 1 : value + 1);
        }
        for (int e : array) {
            if (counts.get(e) > 1) return e;
        }

        return Integer.MIN_VALUE;
    }

    /**
     * Counting sort - only possible if we know the range
     * Time complexity - O(n + k)
     * Space complexity - O(k)
     */
    public int solve3(int[] array, int k) {
        int[] counts = new int[k];

        for (int e : array) {
            counts[e]++;
        }

        for (int e : array) {
            if (counts[e] > 1) return e;
        }

        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve2(new int[]{1, 10, 48, 13, 3, 12, 12, 35, 48}));
    }
}
