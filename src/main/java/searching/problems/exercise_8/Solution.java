package searching.problems.exercise_8;

/**
 * Find max in bitonic array
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve1(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int element : array) {
            if (element > max) {
                max = element;
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
        return solve2(array, 0, array.length - 1);
    }

    private int solve2(int[] array, int low, int high) {
        if (low > high) return Integer.MIN_VALUE;

        int mid = low + (high - low) / 2;
        int previous = mid > 0 ? array[mid - 1] : Integer.MIN_VALUE;
        int current = array[mid];
        int next = mid < array.length - 1 ? array[mid + 1] : Integer.MIN_VALUE;

        if (previous < current && current > next) { // Maxima
            return current;
        } else if (previous < current && current < next) { // Increasing
            return solve2(array, mid + 1, high);
        } else if (previous > current && current > next) { // Decreasing
            return solve2(array, low, mid - 1);
        } else { // No maxima
            return Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solve2(new int[]{4, 3, 2, 1}));
    }
}
