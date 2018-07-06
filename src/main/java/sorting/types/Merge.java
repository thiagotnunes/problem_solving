package sorting.types;

import java.util.Arrays;

/**
 * Merge sort
 * Worst case time complexity - O(nlogn)
 * Average case time complexity - O(nlogn)
 * Best case time complexity - O(nlogn)
 * Space complexity - O(n)
 * Stable? - yes
 */
public class Merge {
    public static void sort(int[] array) {
        int n = array.length;
        int[] buffer = new int[n];

        sort(array, 0, array.length - 1, buffer);
    }

    private static void sort(int[] array, int lo, int hi, int[] buffer) {
        if (lo >= hi) {
            buffer[lo] = array[lo];
            return;
        }

        int mid = (hi - lo) / 2 + lo;
        sort(array, lo, mid, buffer);
        sort(array, mid + 1, hi, buffer);

        merge(array, lo, mid, hi, buffer);
    }

    private static void merge(int[] array, int lo, int mid, int hi, int[] buffer) {
        int i = lo;
        int j = mid + 1;
        int k = lo;

        while (i <= mid || j <= hi) {
            if (i > mid) {
                buffer[k] = array[j++];
            } else if (j > hi) {
                buffer[k] = array[i++];
            } else if (array[i] <= array[j]) {
                buffer[k] = array[i++];
            } else {
                buffer[k] = array[j++];
            }
            k++;
        }

        System.arraycopy(buffer, lo, array, lo, hi - lo + 1);
    }

    public static void main(String[] args) {
        int[] array = {10, 3, 6, 1, 9, 2, 7, 5, 4, 11, 12, 34, 14, 15};

        Merge.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
