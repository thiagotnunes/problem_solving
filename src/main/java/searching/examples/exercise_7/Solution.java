package searching.examples.exercise_7;

import util.Pair;

import java.util.Arrays;

/**
 * Find two elements whose sum is closest to zero
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n^2)
     * Space complexity - O(1)
     */
    public Pair solve1(int[] array) {
        int min = Integer.MAX_VALUE;
        Pair minPair = null;

        for (int i = 0; i < array.length - 1; i++) {
            int first = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int second = array[j];
                if (Math.abs(first + second) < min) {
                    min = Math.abs(first + second);
                    minPair = new Pair(first, second);
                }
            }
        }

        return minPair;
    }

    /**
     * Sorting - only possible if we can mutate the array
     * Time complexity - O(nlogn)
     * Space complexity - O(1)
     */
    public Pair solve2(int[] array) {
        Arrays.sort(array);

        int i = 0;
        int j = array.length - 1;
        int min = Integer.MAX_VALUE;
        Pair minPair = null;
        while (i > j) {
            int first = array[i];
            int second = array[j];
            int sum = first + second;

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                minPair = new Pair(first, second);
            }

            if (sum == 0) {
                return new Pair(first, second);
            } else if (sum < 0) {
                i++;
            } else {
                j--;
            }
        }

        return minPair;
    }
}
