package searching.problems.exercise_6;

import util.Pair;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Find pair in two arrays that sum up to given value
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n^2)
     * Space complexity - O(1)
     */
    public Pair solve1(int[] array1, int[] array2, int value) {
        for (int first : array1) {
            for (int second : array2) {
                if (first + second == value)
                    return new Pair(first, second);
            }
        }
        return null;
    }

    /**
     * Sorting - only possible if we can mutate the arrays
     * Time complexity - O(nlogn)
     * Space complexity - O(1)
     */
    public Pair solve2(int[] array1, int[] array2, int value) {
        Arrays.sort(array1);
        Arrays.sort(array2);

        int i = 0;
        int j = array2.length;

        while (i < array1.length && j >= 0) {
            int first = array1[i];
            int second = array2[j];
            int sum = first + second;

            if (sum == value) {
                return new Pair(first, second);
            } else if (sum < value) {
                i++;
            } else {
                j--;
            }
        }

        return null;
    }

    /**
     * HashMap
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public Pair solve3(int[] array1, int[] array2, int value) {
        HashSet<Integer> seen = new HashSet<>();
        for (int element : array1) {
            seen.add(element);
        }

        for (int element : array2) {
            int complement = value - element;
            if (seen.contains(complement)) {
                return new Pair(complement, element);
            }
        }

        return null;
    }

    /**
     * Counting sort - only possible
     * Time complexity - O(n + k)
     * Space complexity - O(k)
     */
    public Pair solve4(int[] array1, int[] array2, int value, int k) {
        int[] counts = new int[k];
        for (int i = 0; i < array1.length; i++) {
            counts[i]++;
        }

        for (int element : array2) {
            int complement = value - element;
            if (counts[complement] > 0) {
                return new Pair(complement, element);
            }
        }

        return null;
    }

}
