package priority_queue.examples.example_2;

import java.util.Arrays;

/**
 * K largest numbers in a stream of numbers
 */
public class Solution {
    /**
     * Min heap
     * Time complexity - O(nlogk)
     * Space complexity - O(k)
     */
    public int[] solve1(int[] array, int k) {
        int[] heap = new int[k];

        for (int i = 0; i < heap.length; i++) {
            heap[i] = Integer.MIN_VALUE;
        }

        for (int e : array) {
            if (e > heap[0]) {
                heap[0] = e;
                siftDown(heap, 0);
            }
        }

        return heap;
    }

    private void siftDown(int[] array, int i) {
        if (i >= array.length) return;

        int leftI = 2 * i + 1;
        int rightI = 2 * i + 2;
        int current = array[i];
        int left = leftI < array.length ? array[leftI] : Integer.MAX_VALUE;
        int right = rightI < array.length ? array[rightI] : Integer.MAX_VALUE;
        int min = Math.min(left, right);

        if (min < current && min == left) {
            array[i] = left;
            array[leftI] = current;
            siftDown(array, leftI);
        } else if (min < current) {
            array[i] = right;
            array[rightI] = current;
            siftDown(array, rightI);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{6,5,7,4,8,3,9,2,0,1};

        System.out.println(Arrays.toString(solution.solve1(array, 4)));
    }
}
