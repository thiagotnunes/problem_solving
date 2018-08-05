package priority_queue.examples.example_1;

import priority_queue.types.MinHeap;

/**
 * Kth smallest
 */
public class Solution {
    /**
     * If we need to create a heap
     * Time complexity - O(n + klogn)
     * Space complexity - O(1)
     */
    public int solve1(int[] array, int k) {
        int n = array.length;
        heapify(array, n);
        for (int i = 0; i < k - 1; i++) {
            extractMin(array, n--);
        }

        return extractMin(array, n);
    }

    /**
     * If a min heap is given
     * Time complexity - O(klogn)
     * Space complexity - O(1)
     */
    public int solve2(MinHeap heap, int k) {
        for (int i = 0; i < k - 1; i++) {
            heap.extract();
        }
        return heap.extract();
    }

    // O(logn)
    private int extractMin(int[] array, int length) {
        int min = array[0];
        array[0] = array[length - 1];

        siftDown(array, length - 1, 0);

        return min;
    }

    // O(logn)
    private void heapify(int[] array, int n) {
        for (int i = n / 2; i >= 0; i--) {
            siftDown(array, n, i);
        }
    }

    // O(logn)
    private void siftDown(int[] array, int length, int i) {
        if (i >= length) return;

        int leftI = 2 * i + 1;
        int rightI = 2 * i + 2;
        int parent = array[i];
        int left = leftI < length ? array[leftI] : Integer.MAX_VALUE;
        int right = rightI < length ? array[rightI] : Integer.MAX_VALUE;
        int min = Math.min(left, right);

        if (min < parent && min == left) {
            array[i] = left;
            array[leftI] = parent;
            siftDown(array, length, leftI);
        } else if (min < parent) {
            array[i] = right;
            array[rightI] = parent;
            siftDown(array, length, rightI);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {6, 5, 7, 4, 8, 3, 9, 2, 0, 1};
        MinHeap heap = MinHeap.heapify(array);

        System.out.println(solution.solve2(heap, 3));
    }
}
