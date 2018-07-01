package searching.exercises.exercise_6;

/**
 * Given an array of monotonically increasing elements find the point when it
 * turns from negative to positive
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve1(int[] array) {
        int n = array.length;

        if (n == 0) return Integer.MIN_VALUE;
        if (array[0] >= 0) return 0;

        for (int i = 1; i < n; i++) {
            if (array[i] >= 0 && array[i - 1] < 0) return i;
        }

        return Integer.MIN_VALUE;
    }

    /**
     * Binary search
     * Time complexity - O(logn)
     * Space complexity - O(1)
     */
    public int solve2(int[] array) {
        return binarySearch(0, array.length - 1, array);
    }

    private int binarySearch(int lo, int hi, int[] array) {
        if (lo > hi) return Integer.MIN_VALUE;
        if (array[lo] >= 0 && array[hi] >= 0) return lo;
        if (array[lo] < 0 && array[hi] < 0) return Integer.MIN_VALUE;

        int mid = (hi - lo) / 2 + lo;
        if (array[mid] >= 0) {
            if (array[mid - 1] < 0) {
                return mid;
            } else {
                return binarySearch(lo, mid - 1, array);
            }
        } else {
            if (array[mid + 1] >= 0) {
                return mid + 1;
            } else {
                return binarySearch(mid + 1, hi, array);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve2(new int[]{-1, -2, 1, 2}));
    }
}
