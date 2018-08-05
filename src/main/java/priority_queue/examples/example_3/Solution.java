package priority_queue.examples.example_3;

import priority_queue.types.MinHeap;

import java.util.Arrays;

/**
 * Merge two heaps
 */
public class Solution {
    /**
     * MinHeap, extract min
     * Time complexity - O(nlogn + mlogm)
     * Space complexity - O(n + m)
     */
    public int[] solve1(MinHeap heap1, MinHeap heap2) {
        int n = heap1.size();
        int m = heap2.size();
        int[] merged = new int[n + m];

        for (int i = 0; i < merged.length; i++) {
            int min1 = heap1.isEmpty() ? Integer.MAX_VALUE : heap1.peek();
            int min2 = heap2.isEmpty() ? Integer.MAX_VALUE : heap2.peek();

            if (min1 < min2) {
                merged[i] = heap1.extract();
            } else {
                merged[i] = heap2.extract();
            }
        }

        return merged;
    }

    /**
     * Copy and heapify
     * Time complexity - O(n + m)
     * Space complexity - O(n + m)
     */
    public int[] solve2(MinHeap heap1, MinHeap heap2) {
        int[] heapArray1 = heap1.getArray();
        int[] heapArray2 = heap2.getArray();
        int n = heapArray1.length;
        int m = heapArray2.length;
        int[] merged = new int[n + m];

        int k = 0;
        for (int e : heapArray1) {
            merged[k++] = e;
        }
        for (int e : heapArray2) {
            merged[k++] = e;
        }

        MinHeap.heapify(merged);

        return merged;
    }

    /**
     * Insert one heaps values into the other
     * This is only good if heap2 is significantly smaller than heap1
     * Time complexity - O(mlogn)
     * Space complexity - O(m)
     */
    public int[] solve3(MinHeap heap1, MinHeap heap2) {
        int[] heap2Array = heap2.getArray();

        for (int e : heap2Array) {
            heap1.add(e);
        }

        return heap1.getArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array1 = new int[]{5, 4, 6, 3, 7, 2, 8, 1, 9, 0};
        int[] array2 = new int[]{10, 5, 20, 3, 40, 7, 9};
        MinHeap heap1 = MinHeap.heapify(array1);
        MinHeap heap2 = MinHeap.heapify(array2);

        int[] result = solution.solve3(heap1, heap2);
        System.out.println(Arrays.toString(result));
    }
}
