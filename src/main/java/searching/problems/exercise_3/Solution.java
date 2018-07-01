package searching.problems.exercise_3;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Find the element that appears more than n/2 times
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
        for (int element : array) {
            if (element == current) {
                count++;
            } else {
                current = element;
                count = 1;
            }

            if (count > array.length / 2) {
                return current;
            }
        }

        return current;
    }

    /**
     * HashMap
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public int solve3(int[] array) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int element : array) {
            counts.compute(element, (key, value) -> value == null ? 1 : value + 1);

            if (counts.get(element) > array.length / 2) {
                return element;
            }
        }

        return Integer.MIN_VALUE;
    }

    /**
     * Moore's Voting
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve4(int[] array) {
        int votes = 1;
        int majorityElement = array[0];

        for (int element : array) {
            if (element == majorityElement) {
                votes++;
            } else {
                votes--;
            }

            if (votes == 0) {
                majorityElement = element;
                votes = 1;
            }
        }

        int count = 0;
        for (int element : array) {
            if (element == majorityElement) {
                count++;
            }

            if (count > array.length / 2) {
                return majorityElement;
            }
        }

        return Integer.MIN_VALUE;
    }
}
