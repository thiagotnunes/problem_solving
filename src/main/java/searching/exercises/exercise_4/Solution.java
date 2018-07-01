package searching.exercises.exercise_4;

import java.util.Arrays;

/**
 * Separate 0s and 1s
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
            int e = array[i];
            for (int j = i + 1; j < n; j++) {
                if (e > array[j]) {
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
        int n = array.length;
        int[] counts = new int[2];

        for (int e : array) {
            counts[e]++;
        }

        int k = 0;
        for (int i = 0; i < 2; i++) {
            int count = counts[i];
            for (int j = 0; j < count; j++) {
                array[k++] = i;
            }
        }
    }

    /**
     * Partition
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public void solve4(int[] array) {
        int n = array.length;
        int p = 0;

        for (int i = 0; i < n; i++) {
            if (array[i] == 0) {
                array[i] = array[p];
                array[p] = 0;
                p++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] array = {0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1};
        solution.solve4(array);

        System.out.println(Arrays.toString(array));
    }
}
