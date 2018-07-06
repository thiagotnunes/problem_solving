package sorting.exercises.exercise_13;

import java.util.Arrays;

/**
 * Given an array of 0s and 1s, sort the array in ascending order
 */
public class Solution {
    /**
     * Sorting
     * Time complexity - O(nlogn)
     * Space complexity - O(1)
     */
    public void solve1(int[] array) {
        Arrays.sort(array);
    }

    /**
     * Partition (from Quicksort)
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public void solve2(int[] array) {
        int n = array.length;

        int i = 0;
        int j = 0;
        while (i < n) {
            if (array[i] < 1) {
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
                j++;
            }
            i++;
        }
    }

    /**
     * Counting sort
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public void solve3(int[] array) {
        int counts[] = new int[2];

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
        int[] array = {1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0};

        solution.solve3(array);

        System.out.println(Arrays.toString(array));
    }
}
