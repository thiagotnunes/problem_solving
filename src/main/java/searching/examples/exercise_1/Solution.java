package searching.examples.exercise_1;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Print duplicates in an array
 */
public class Solution {
    /**
     * Brute force solution
     * Time complexity - O(n^2)
     * Space complexity - O(1)
     */
    public void solution1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int element = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (element == array[j]) System.out.println(element + " appears at array[" + i + "] and array[" + j + "]");
            }
        }
    }

    /**
     * Sorting - only possible if we can mutate the array
     * Time complexity - O(nlogn)
     * Space complexity - O(1)
     */
    public void solution2(int[] array) {
        if (array.length == 0) return;

        Arrays.sort(array);

        int element = array[0];
        for (int i = 1; i < array.length; i++) {
            if (element == array[i]) {
                System.out.println("Found duplicate element " + element);
            } else {
                element = array[i];
            }
        }
    }

    /**
     * HashSet
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public void solution3(int[] array) {
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            if (!seen.contains(element)) {
                seen.add(element);
            } else {
                System.out.println("Found duplicate element " + element);
            }
        }
    }

    /**
     * Counting sort - only possible if we know the max range
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public void solution4(int[] array, int max) {
        int[] seen = new int[max];

        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            if (seen[element] > 0) {
                System.out.println("Found duplicate element " + element);
            }
            seen[element]++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("Solution 1");
        solution.solution1(new int[]{2, 3, 4, 2, 4, 3, 1});
        System.out.println("Solution 2");
        solution.solution2(new int[]{2, 3, 4, 2, 4, 3, 1});
        System.out.println("Solution 3");
        solution.solution3(new int[]{2, 3, 4, 2, 4, 3, 1});
        System.out.println("Solution 4");
        solution.solution4(new int[]{2, 3, 4, 2, 4, 3, 1}, 10);
    }
}
