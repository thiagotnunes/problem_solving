package searching.exercises.exercise_3;

import java.util.Arrays;

/**
 * Given an array of positive and negative numbers, separate them
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public void solve1(int[] array) {
        int n = array.length;
        int[] separated = new int[n];

        int j = 0;
        int k = n - 1;
        for (int e : array) {
            if (e < 0) separated[j++] = e;
            else separated[k--] = e;
        }

        System.arraycopy(separated, 0, array, 0, n);
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
     * Partitioning
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public void solve3(int[] array) {
        int tmp;
        int p = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                tmp = array[i];
                array[i] = array[p];
                array[p] = tmp;
                p++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {-1, 1, -2, 2, -3, 3, 4, 5, 6, -7, 8, -9};

        solution.solve3(array);
        System.out.println(Arrays.toString(array));
    }
}
