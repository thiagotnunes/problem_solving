package searching.exercises.exercise_9;

/**
 * Find min in a sorted rotated array
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve1(int[] array) {
        int min = Integer.MAX_VALUE;

        for (int e : array) {
            if (e < min) {
                min = e;
            }
        }

        return min;
    }

    public int solve2(int[] array) {
        int minSorted = array[0];
        int minRotated = binarySearch(0, array.length - 1, array);

        return minSorted < minRotated ? minSorted : minRotated;
    }

    // 4 5 1 2 3
    // 2 3 4 5 1
    private int binarySearch(int lo, int hi, int[] array) {
        if (lo > hi) return Integer.MAX_VALUE;

        int mid = (hi - lo) / 2 + lo;
        if (mid > 0 && array[mid] < array[mid - 1]) {
            return array[mid];
        } else if (array[mid] < array[hi]) {
            return binarySearch(lo, mid - 1, array);
        } else {
            return binarySearch(mid + 1, hi, array);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve2(new int[]{10, 11, 1, 2, 3, 4, 5}));
    }
}
