package sorting.types;

import data_structures.MaxHeap;

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
