package searching.problems.exercise_16;

/**
 * Search for an element in a rotated array
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve1(int[] array, int e) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == e) return i;
        }
        return -1;
    }

    /**
     * Binary Search
     * Time complexity - O(logn) (logn for rotation pos + logn for left search + logn for right search)
     * Space complexity - O(1)
     */
    public int solve2(int[] array, int e) {
        int rotationPos = binarySearchRotation(array, 0, array.length);

        int leftSearch = binarySearch(array, 0, rotationPos, e);
        int rightSearch = binarySearch(array, rotationPos + 1, array.length - 1, e);

        if (leftSearch > -1) return leftSearch;
        return rightSearch;
    }

    private int binarySearchRotation(int[] array, int lo, int hi) {
        if (lo > hi) return -1;

        int mid = (hi - lo) / 2 + lo;

        if (array[mid] < array[mid - 1]) {
            return mid;
        }
        if (array[mid] < array[lo]) {
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
        } else if (array[mid] < e) {
            return binarySearch(array, mid + 1, hi, e);
        } else {
            return binarySearch(array, lo, mid - 1, e);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve2(new int[]{7, 8, 9, 10, 1, 2, 3, 4, 5, 6}, 3));
    }
}
