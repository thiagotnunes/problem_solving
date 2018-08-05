package priority_queue.examples.example_6;

/**
 * Check if given array is a max heap
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(logn) (for the system stack)
     */
    public boolean solve1(int[] array) {
        return isMaxHeap(array, array.length, 0);
    }

    private boolean isMaxHeap(int[] array, int n, int i) {
        if (i >= n) return true;

        int leftI = 2 * i + 1;
        int rightI = 2 * i + 2;
        int left = leftI < n ? array[leftI] : Integer.MIN_VALUE;
        int right = rightI < n ? array[rightI] : Integer.MIN_VALUE;
        int current = array[i];

        return current >= left &&
                current >= right &&
                isMaxHeap(array, n, leftI) &&
                isMaxHeap(array, n, rightI);
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
            if (leftI < n && array[i] < array[leftI]) {
                return false;
            }
            if (rightI < n && array[i] < array[rightI]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve2(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }
}
