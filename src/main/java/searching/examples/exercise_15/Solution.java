package searching.examples.exercise_15;

/**
 * Find the position of the first 1 in a sorted 0, 1 array
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) return i;
        }

        return -1;
    }

    /**
     * Binary search
     * Time complexity - O(logn)
     * Space complexity - O(1)
     */
    public int solve2(int[] array) {
        return binarySearch(array, 0, array.length - 1);
    }

    private int binarySearch(int[] array, int lo, int hi) {
        if (lo == hi && array[lo] == 1) return lo;
        if (lo >= hi) return -1;

        int mid = (hi - lo) / 2 + lo;

        if (array[mid] == 1 && array[mid - 1] == 0) {
            return mid;
        } else if (array[mid] == 1) {
            return binarySearch(array, lo, mid - 1);
        } else {
            return binarySearch(array, mid + 1, hi);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve2(new int[]{0, 0, 0, 1}));
    }
}
