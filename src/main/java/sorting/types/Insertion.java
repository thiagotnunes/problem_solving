package sorting.types;

import java.util.Arrays;

/**
 * Insertion sort
 * Worst case time complexity - O(n^2)
 * Average case time complexity -  O(n^2)
 * Best case time complexity - O(n) (when the array is already sorted)
 * Space complexity - O(1)
 * Stable? - yes
 */
public class Insertion {
    public static void sort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
                int tmp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 1, 2, 3, 5, 1, 9, 14, 78, 32, 12, 43};

        Insertion.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
