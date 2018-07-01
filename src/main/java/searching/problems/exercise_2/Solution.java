package searching.problems.exercise_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of n numbers, find the number which appears
 * the most times
 */
public class Solution {
    /**
     * Brute force solution
     * Time complexity - O(n^2)
     * Space complexity - O(1)
     */
    public int solve1(int[] array) {
        int max = 0;
        int maxElement = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int count = 1;
            int element = array[i];

            for (int j = i + 1; j < array.length; j++) {
                if (element == array[j]) {
                    count++;
                }
            }

            if (count > max) {
                max = count;
                maxElement = element;
            }
        }

        return maxElement;
    }

    /**
     * Sorting - only possible if we can mutate the array
     * Time complexity - O(nlogn)
     * Space complexity - O(1)
     */
    public int solve2(int[] array) {
        Arrays.sort(array);

        int current = Integer.MIN_VALUE;
        int count = 0;
        int maxElement = current;
        int max = count;
        for (int element : array) {
            if (element == current) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                    maxElement = current;
                }
                current = element;
                count = 1;
            }
        }

        return maxElement;
    }

    /**
     * Counting sort - only possible if we know the max range (k)
     * Time complexity - O(n + k)
     * Space complexity - O(k)
     */
    public int solve3(int[] array, int maxRange) {
        int[] sorted = new int[maxRange];

        for (int element : array) {
            sorted[element]++;
        }

        int max = 0;
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] > max) {
                max = sorted[i];
                maxElement = i;
            }
        }

        return maxElement;
    }

    /**
     * HashMap
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public int solve4(int[] array) {
        HashMap<Integer, Integer> keyToCount = new HashMap<>();

        for (int element : array) {
            keyToCount.compute(element, (key, value) -> value == null ? 1 : value + 1);
        }

        int max = 0;
        int maxElement = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : keyToCount.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxElement = entry.getKey();
            }
        }

        return maxElement;
    }
}
