package searching.exercises.exercise_8;

/**
 * Find max element in a sorted rotated array
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve1(int[] array) {
        int max = Integer.MIN_VALUE;

        for (int e : array) {
            if (e > max) {
                max = e;
            }
        }

        return max;
    }

    /**
     * Binary search
     * Time complexity - O(logn)
     * Space complexity - O(1)
     */
    public int solve2(int[] array) {
        int maxSorted = array[array.length - 1];
        int maxRotated = binarySearch(0, array.length - 1, array);

        return maxSorted > maxRotated ? maxSorted : maxRotated;
    }

    private int binarySearch(int lo, int hi, int[] array) {
        if (lo > hi) return Integer.MIN_VALUE;

        int mid = (hi - lo) / 2 + lo;
        if (mid < array.length - 1 && array[mid] > array[mid + 1]) {
            return array[mid];
        } else if (array[mid] < array[hi]) {
            return binarySearch(lo, mid - 1, array);
        } else {
            return binarySearch(mid + 1, hi, array);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve2(new int[]{3, 4, 5, 6, 1, 2}));
    }
}
