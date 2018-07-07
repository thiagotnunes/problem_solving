package sorting.exercises.exercise_3;

import java.util.Arrays;

/**
 * Given K sorted arrays of length M and an output array of size K*M
 * merge all the arrays into the output
 */
public class Solution {
    private class HeapNode {
        public final int arrayI;
        public final int elementI;
        public final int data;

        public HeapNode(int arrayI, int elementI, int data) {
            this.arrayI = arrayI;
            this.elementI = elementI;
            this.data = data;
        }
    }

    /**
     * Sorting
     * Time complexity - O(n * k * logkn)
     * Space complexity - O(1)
     */
    public int[] solve1(int[][] arrays) {
        int k = arrays.length;
        int m = arrays[0].length;
        int[] output = new int[k * m];

        for (int i = 0; i < k; i++) {
            System.arraycopy(arrays[i], 0, output, i * m, m);
        }

        Arrays.sort(output);

        return output;
    }

    /**
     * MinHeap
     * Time complexity - O(n * k * logk)
     * Space complexity - O(k)
     */
    public int[] solve2(int[][] arrays) {
        int k = arrays.length;
        int m = arrays[0].length;
        int[] output = new int[k * m];
        int heapSize = k;

        HeapNode[] minHeap = new HeapNode[k];
        for (int i = 0; i < heapSize; i++) {
            minHeap[i] = new HeapNode(i, 0, arrays[i][0]);
        }

        heapify(minHeap, heapSize);

        int j = 0;
        for (int i = 0; i < k * m; i++) {
            HeapNode heapNode = extractMin(minHeap, heapSize, arrays);
            output[j] = heapNode.data;

            if (heapNode.elementI + 1 < arrays[heapNode.arrayI].length) {
                minHeap[heapSize - 1] = new HeapNode(
                        heapNode.arrayI,
                        heapNode.elementI + 1,
                        arrays[heapNode.arrayI][heapNode.elementI + 1]
                );
                siftUp(minHeap, heapSize - 1);
            } else {
                heapSize--;
            }

            j++;
        }

        return output;
    }

    private HeapNode extractMin(HeapNode[] minHeap, int heapSize, int[][] arrays) {
        HeapNode min = minHeap[0];
        minHeap[0] = minHeap[heapSize - 1];
        siftDown(minHeap, heapSize, 0);

        return min;
    }

    private void heapify(HeapNode[] minHeap, int heapSize) {
        for (int i = (heapSize + 1) / 2; i >= 0; i--) {
            siftUp(minHeap, i);
        }
    }

    private void siftUp(HeapNode[] minHeap, int i) {
        if (i == 0) return;

        int parentI = i % 2 == 0 ? i / 2 - 1 : i / 2;
        int currentData = minHeap[i].data;
        int parentData = minHeap[parentI].data;

        if (currentData < parentData) {
            HeapNode tmp = minHeap[i];
            minHeap[i] = minHeap[parentI];
            minHeap[parentI] = tmp;
            siftUp(minHeap, parentI);
        }
    }

    private void siftDown(HeapNode[] minHeap, int heapSize, int i) {
        if (i > heapSize - 1) return;

        int leftI = 2 * i + 1;
        int rightI = 2 * i + 2;
        int current = minHeap[i].data;
        int left = leftI < heapSize ? minHeap[leftI].data : Integer.MAX_VALUE;
        int right = rightI < heapSize ? minHeap[rightI].data : Integer.MAX_VALUE;
        int min = Math.min(left, right);

        if (min < current && min == left) {
            HeapNode tmp = minHeap[i];
            minHeap[i] = minHeap[leftI];
            minHeap[leftI] = tmp;
            siftDown(minHeap, heapSize, leftI);
        } else if (min < current && min == right) {
            HeapNode tmp = minHeap[i];
            minHeap[i] = minHeap[rightI];
            minHeap[rightI] = tmp;
            siftDown(minHeap, heapSize, rightI);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] sorted = solution.solve2(new int[][]{
                new int[]{2, 4, 6, 8, 10, 12},
                new int[]{1, 3, 5, 7, 9, 11},
                new int[]{0, 5, 10, 15, 20, 25},
                new int[]{3, 6, 9, 12, 15, 18}
        });

        System.out.println(Arrays.toString(sorted));
    }
}
