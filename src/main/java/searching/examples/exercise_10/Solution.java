package searching.examples.exercise_10;

/**
 * Find the occurrences of a number in a sorted array
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve1(int[] array, int value) {
        int count = 0;
        for (int element : array) {
            if (element == value) {
                count++;
            }
        }

        return count;
    }

    /**
     * Binary search
     * We have to binary search for the boundaries of the number we are looking for
     * Time complexity - O(logn)
     * Space complexity O(1)
     */
    public int solve2(int[] array, int value) {
        int predecessor = findPredecessorPosition(array, value, 0, array.length);
        int successor = findSuccessorPosition(array, value, 0, array.length);

        if (predecessor > Integer.MIN_VALUE && successor > Integer.MIN_VALUE) {
            return successor - predecessor - 1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    private int findPredecessorPosition(int[] array, int value, int low, int high) {
        if (low > high) return Integer.MIN_VALUE;

        int mid = low + (high - low) / 2;
        int current = array[mid];
        int next = array[mid + 1];

        if (current == value && mid == 0) {
            return low - 1;
        } else if (current != value && next == value) {
            return mid;
        } else if (current >= value) {
            return findPredecessorPosition(array, value, low, mid - 1);
        } else {
            return findPredecessorPosition(array, value, mid + 1, high);
        }
    }

    // 1 2 3 3 4 5
    private int findSuccessorPosition(int[] array, int value, int low, int high) {
        if (low > high) return Integer.MIN_VALUE;

        int mid = low + (high - low) / 2;
        int current = array[mid];
        int previous = array[mid - 1];

        if (current == value && mid == array.length - 1) {
            return high;
        } else if (current != value && previous == value) {
            return mid;
        } else if (current <= value) {
            return findSuccessorPosition(array, value, mid + 1, high);
        } else {
            return findSuccessorPosition(array, value, low, mid - 1);
        }
    }
}
