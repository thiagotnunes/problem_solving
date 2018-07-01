package searching.examples.exercise_9;

/**
 * Search for an element in a bitonic array
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public Boolean solve1(int[] array, int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }

        return false;
    }

    /**
     * Binary search - First find maxima and then binary search both sides
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public Boolean solve2(int[] array, int value) {
        int k = findMaximaPosition(array, 0, array.length - 1);

        return solve2(array, value, 0, k) && solve2(array, value, k + 1, array.length - 1);
    }

    private int findMaximaPosition(int[] array, int low, int high) {
        if (low > high) return Integer.MIN_VALUE;

        int mid = low + (high - low) / 2;
        int previous = mid > 0 ? array[mid - 1] : Integer.MIN_VALUE;
        int current = array[mid];
        int next = mid < array.length - 1 ? array[mid + 1] : Integer.MIN_VALUE;

        if (previous < current && current > next) { // Maxima
            return mid;
        } else if (previous < current && current < next) { // Increasing
            return findMaximaPosition(array, mid + 1, high);
        } else if (previous > current && current > next) { // Decreasing
            return findMaximaPosition(array, low, mid - 1);
        } else { // No maxima
            return Integer.MIN_VALUE;
        }
    }

    private Boolean solve2(int[] array, int value, int low, int high) {
        if (low > high) return false;

        int mid = low + (high - low) / 2;
        int current = array[mid];

        if (current == value) {
            return true;
        } else if (value > current) {
            return solve2(array, value, mid + 1, high);
        } else {
            return solve2(array, value, low, mid - 1);
        }
    }
}
