package sorting.exercises.exercise_10;

/**
 * Given a sorted rotated array with unique elements, find the index
 * of a given element
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve1(int[] array, int e) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == e) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Binary search
     * Time complexity - O(logn)
     * Space complexity - O(1)
     */
    public int solve2(int[] array, int e) {
        int rotationPos = binarySearchRotation(array, 0, array.length - 1);

        int left = binarySearch(array, 0, rotationPos - 1, e);
        int right = binarySearch(array, rotationPos, array.length - 1, e);

        return Math.max(left, right);
    }

    private int binarySearchRotation(int[] array, int lo, int hi) {
        if (lo > hi) return -1;

        int mid = (hi - lo) / 2 + lo;
        if (mid > 0 && array[mid] < array[mid - 1]) {
            return mid;
        } else if (array[mid] < array[lo]) {
            return binarySearchRotation(array, lo, mid - 1);
        } else {
            return binarySearchRotation(array, mid + 1, hi);
        }
    }

    private int binarySearch(int[] array, int lo, int hi, int e) {
        if (lo > hi) return -1;

        int mid = (hi - lo) / 2 + lo;
        if (array[mid] == e) {
            return mid;
        } else if (array[mid] > e) {
            return binarySearch(array, lo, mid - 1, e);
        } else {
            return binarySearch(array, mid + 1, hi, e);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve2(new int[]{5, 6, 7, 8, 9, 1, 2, 3}, 6));
    }
}
