package priority_queue.examples.example_5;

/**
 * Check if given array is a min heap
 */
public class Solution {
    /**
     * Recursive
     * Time complexity - O(n)
     * Space complexity - O(logn) (for the system stack)
     */
    public boolean solve1(int[] array) {
        return isMinHeap(array, array.length, 0);
    }

    private boolean isMinHeap(int[] array, int n, int i) {
        if (i >= n) return true;

        int leftI = 2 * i + 1;
        int rightI = 2 * i + 2;
        int left = leftI < n ? array[leftI] : Integer.MAX_VALUE;
        int right = rightI < n ? array[rightI] : Integer.MAX_VALUE;
        int current = array[i];

        return current <= left &&
                current <= right &&
                isMinHeap(array, n, leftI) &&
                isMinHeap(array, n, rightI);
    }

    /**
     * Iterative
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public boolean solve2(int[] array) {
        int n = array.length;

        for (int i = 0; i < n / 2; i++) {
            int leftI = 2 * i + 1;
            int rightI = 2 * i + 2;
            if (leftI < n && array[i] > array[leftI]) {
                return false;
            }
            if (rightI < n && array[i] > array[rightI]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
