package sorting.types;

import java.util.Arrays;

/**
 * Heap sort
 * Worst case time complexity - O(nlogn)
 * Average case time complexity - O(nlogn)
 * Best case time complexity - O(nlogn)
 * Space complexity - O(1)
 * Stable? - no
 */
public class Heap {
    private static class MaxHeap {
        private int size;
        private final int[] heap;

        public MaxHeap(int[] array) {
            this.size = array.length;
            this.heap = array;
            heapify();
        }

        private void heapify() {
            for (int i = size / 2; i >= 0; i--) {
                siftDown(i);
            }
        }

        private void siftDown(int i) {
            int current = heap[i];
            int leftPos = leftChild(i);
            int rightPos = rightChild(i);
            int left = leftPos >= size ? Integer.MIN_VALUE : heap[leftPos];
            int right = rightPos >= size ? Integer.MIN_VALUE : heap[rightPos];
            int max = Math.max(left, right);

            if (current < max) {
                if (max == left) {
                    heap[leftPos] = current;
                    heap[i] = left;
                    siftDown(leftPos);
                } else {
                    heap[rightPos] = current;
                    heap[i] = right;
                    siftDown(rightPos);
                }
            }
        }

        public int extractMax() {
            int max = heap[0];

            heap[0] = heap[size - 1];
            heap[size - 1] = max;
            size--;
            siftDown(0);

            return max;
        }

        private int leftChild(int i) {
            return 2 * i + 1;
        }

        private int rightChild(int i) {
            return 2 * i + 2;
        }
    }

    public static void sort(int[] array) {
        MaxHeap maxHeap = new MaxHeap(array);
        for (int i = 0; i < array.length; i++) {
            maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 6, 4, 7, 3, 8, 2, 9, 1};

        Heap.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
