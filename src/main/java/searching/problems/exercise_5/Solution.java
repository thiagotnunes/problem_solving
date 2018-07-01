package searching.problems.exercise_5;

import util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Find pair in array that sum up to value
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n^2)
     * Space complexity - O(1)
     */
    public Pair solve1(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            int first = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int second = array[j];
                if (first + second == value) {
                    return new Pair(first, second);
                }
            }
        }

        return null;
    }

    /**
     * Sorting - only possible if we can mutate the array
     * Time complexity - O(nlogn)
     * Space complexity - O(1)
     */
    public Pair solve2(int[] array, int value) {
        Arrays.sort(array);

        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            int sum = array[i] + array[j];
            if (sum == value) {
                return new Pair(array[i], array[j]);
            } else if (sum > value) {
                j--;
            } else {
                i++;
            }
        }

        return null;
    }

    /**
     * HashMap
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public Pair solve3(int[] array, int value) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int element : array) {
            counts.compute(element, (k, v) -> v == null ? 1 : v + 1);
        }

        for (Integer key : counts.keySet()) {
            int complement = value - key;
            Integer count = counts.get(complement);

            if (count != null) {
                if (key != complement || count > 1) {
                    return new Pair(key, complement);
                }
            }
        }

        return null;
    }

    /**
     * Counting sort - only possible if we know the max range
     * Time complexity - O(n + k)
     * Space complexity - O(k)
     */
    public Pair solve4(int[] array, int value, int k) {
        int[] counts = new int[k];

        for (int element : array) {
            counts[element]++;
        }

        for (int element : array) {
            int complement = value - element;
            int count = counts[complement];

            if (count > 0) {
                if (element != complement || count > 1) {
                    return new Pair(element, complement);
                }
            }
        }

        return null;
    }
}
