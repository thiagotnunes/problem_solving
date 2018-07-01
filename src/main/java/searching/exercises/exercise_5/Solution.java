package searching.exercises.exercise_5;

import java.util.Arrays;

/**
 * Given an array of 0s, 1s and 2s separate the values
 */
public class Solution {
    /**
     * Brute force (Bubble sort)
     * Time complexity - O(n^2)
     * Space complexity - O(1)
     */
    public void solve1(int[] array) {
        int n = array.length;
        int tmp;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] > array[j]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    /**
     * Sorting
     * Time complexity - O(nlogn)
     * Space complexity - O(1)
     */
    public void solve2(int[] array) {
        Arrays.sort(array);
    }

    /**
     * Counting sort
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public void solve3(int[] array) {
        int[] counts = new int[3];

        for (int e : array) {
            counts[e]++;
        }

        int k = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            for (int j = 0; j < count; j++) {
                array[k++] = i;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] array = {1, 2, 0, 1, 0, 1, 2, 2, 0, 1, 2, 2, 0};
        solution.solve3(array);

        System.out.println(Arrays.toString(array));
    }
}
