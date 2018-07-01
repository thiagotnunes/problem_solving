package searching.exercises.exercise_1;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Find the first repeated element in the array
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n^2)
     * Space complexity - O(1)
     */
    public int solve1(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int e = array[i];
            for (int j = i + 1; j < n; j++) {
                if (array[j] == e) {
                    return e;
                }
            }
        }

        return Integer.MIN_VALUE;
    }

    /**
     * HashSet
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public int solve2(int[] array) {
        HashSet<Integer> seen = new HashSet<>();

        for (int e : array) {
            if (seen.contains(e)) {
                return e;
            } else {
                seen.add(e);
            }
        }

        return Integer.MIN_VALUE;
    }

    /**
     * Counting sort - only possible if we know the range of values
     * Time complexity - O(n + k)
     * Space complexity - O(k)
     */
    public int solve3(int[] array, int k) {
        int[] counts = new int[k];

        for (int e : array) {
            if (counts[e] > 0) {
                return e;
            } else {
                counts[e]++;
            }
        }

        return Integer.MIN_VALUE;
    }
}
