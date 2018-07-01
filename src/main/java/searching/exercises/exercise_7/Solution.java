package searching.exercises.exercise_7;

/**
 * Find an element in a sorted array. If it is not found return the index
 * that the element would be in.
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve1(int[] array, int target) {
        int n = array.length;

        for (int i = 0; i < n; i++) {
            if (array[i] == target || array[i] > target) {
                return i;
            }
        }

        return n - 1;
    }

    /**
     * Binary search
     * Time complexity - O(logn)
     * Space complexity - O(1)
     */
    public int solve2(int[] array, int target) {
        return binarySearch(0, array.length - 1, target, array);
    }

    private int binarySearch(int lo, int hi, int target, int[] array) {
        if (lo > hi) return lo;

        int mid = (hi - lo) / 2 + lo;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return binarySearch(lo, mid - 1, target, array);
        } else {
            return binarySearch(mid + 1, hi, target, array);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve2(new int[]{1, 2, 3, 4, 5, 7, 8, 9}, 5));
    }
}
