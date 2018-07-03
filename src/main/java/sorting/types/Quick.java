package sorting.types;

import java.util.Arrays;
import java.util.Random;

/**
 * Quick sort
 * Worst case time complexity - O(n^2)
 * Average case time complexity - O(nlogn)
 * Best case time complexity - O(nlogn)
 * Space complexity - O(logn) (for the stack)
 * Stable? - no
 */
public class Quick {
    private Random random;

    public Quick(Random random) {
        this.random = random;
    }

    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int lo, int hi) {
        if (lo > hi) return;

        int p = partition(array, lo, hi);
        sort(array, lo, p - 1);
        sort(array, p + 1, hi);
    }

    private int partition(int[] array, int lo, int hi) {
        int pivotI = random.nextInt(hi - lo + 1) + lo;
        int pivot = array[pivotI];
        array[pivotI] = array[hi];
        array[hi] = pivot;

        int i = 0;
        int j = i;
        while (j <= hi - 1) {
            if (array[j] < pivot) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
            j++;
        }
        array[hi] = array[i];
        array[i] = pivot;

        return i;
    }

    public static void main(String[] args) {
        Quick quick = new Quick(new Random());
        int[] array = {5, 4, 6, 3, 7, 2, 8, 1, 9};

        quick.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
