package searching.exercises.exercise_10;

import java.util.Arrays;

/**
 * Find kth smallest element in the union of two sorted arrays
 */
public class Solution {
    /**
     * Sorting
     * Time complexity - O(nlogn)
     * Space complexity - O(1)
     */
    public int solve1(int[] array, int k) {
        Arrays.sort(array);

        return k - 1 < array.length ? array[k - 1] : array[array.length - 1];
    }

    /**
     * Binary search for union point
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve2(int[] array, int k) {
        int n = array.length;
        int unionPos = binarySearch(0, n - 1, array);
        if (unionPos > 0) {
            int i = 0;
            int j = unionPos;
            int count = 0;

            while (j < n - 1 && i < j && count < k - 1) {
                if (array[i] < array[j]) {
                    i++;
                } else {
                    j++;
                }
                count++;
            }

            return array[i] < array[j] ? array[i] : array[j];
        } else {
            return k - 1 < n ? array[k - 1] : array[n - 1];
        }
    }

    private int binarySearch(int lo, int hi, int[] array) {
        if (lo > hi) return -1;

        int mid = (hi - lo) / 2 + lo;
        if (mid > 0 && array[mid] < array[mid - 1]) {
            return mid;
        } else if (mid < array.length - 1 && array[mid] > array[mid + 1]) {
            return mid + 1;
        } else if (array[mid] < array[lo]) {
            return binarySearch(lo, mid - 1, array);
        } else {
            return binarySearch(mid + 1, hi, array);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve2(new int[]{2, 4, 8, 16, 3, 6, 9, 12}, 5));
    }
}
