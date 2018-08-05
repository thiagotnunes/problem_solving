package priority_queue.exercises.exercise_2_3;

import priority_queue.types.MinHeap;

/**
 * Find the max in a min heap.
 *
 * What is the worst case time complexity of finding the largest element in a min heap?
 * O(n)
 */
public class Solution {
    /**
     * Linear search
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve1(MinHeap minHeap) {
        int[] array = minHeap.getArray();
        int max = Integer.MIN_VALUE;

        for (int e : array) {
            if (e > max) {
                max = e;
            }
        }

        return max;
    }

    /**
     * Linear search on leaves
     * We only need to check the leaves, where the largest elements will be
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve2(MinHeap minHeap) {
        int[] array = minHeap.getArray();
        int n = array.length;
        int max = Integer.MIN_VALUE;

        for (int i = n / 2; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }
}
