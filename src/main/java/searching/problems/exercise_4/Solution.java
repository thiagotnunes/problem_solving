package searching.problems.exercise_4;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Find the missing element in range for an array with no duplicates
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n * k)
     * Space complexity - O(1)
     */
    public int solve1(int[] array, int k) {
        boolean found = false;
        for (int i = 0; i < k; i++) {
            for (int element : array) {
                if (element == i) {
                    found = true;
                    break;
                }
            }
            if (!found)
                return i;
        }

        return Integer.MIN_VALUE;
    }

    /**
     * Sorting - only possible if we can mutate the array
     * Time complexity - O(nlogn + k)
     * Space complexity - O(1)
     */
    public int solve2(int[] array, int k) {
        Arrays.sort(array);

        for (int i = 0; i < k; i++) {
            if (array[i] != i) {
                return i;
            }
        }

        return Integer.MIN_VALUE;
    }

    /**
     * HashSet
     * Time complexity - O(n + k)
     * Space complexity - O(n)
     */
    public int solve3(int[] array, int k) {
        HashSet<Integer> seen = new HashSet<>();
        for (int element : array) {
            seen.add(element);
        }

        for (int i = 0; i < k; i++) {
            if (!seen.contains(i)) {
                return i;
            }
        }

        return Integer.MIN_VALUE;
    }

    /**
     * Counting sort - possible due to the range given
     * Time complexity - O(n + k)
     * Space complexity - O(k)
     */
    public int solve4(int[] array, int k) {
        int[] counts = new int[k];

        for (int element : array) {
            counts[element]++;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) {
                return i;
            }
        }

        return Integer.MIN_VALUE;
    }

    /**
     * Summation
     * Time complexity - O(n + k)
     * Space complexity - O(1)
     */
    public int solve5(int[] array, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += i;
        }

        for (int element : array) {
            sum -= element;
        }

        return sum;
    }
}
