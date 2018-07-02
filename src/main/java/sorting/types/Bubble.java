package sorting.types;

import java.util.Arrays;

/**
 * Bubble sort
 * Worst case time complexity - O(n^2)
 * Average case time complexity - O(n^2)
 * Best case time complexity - O(n) (when the array is already sorted)
 * Space complexity - O(1)
 * Stable? - yes
 */
public class Bubble {
    public static void sort(int[] array) {
        int n = array.length;
        boolean swapped = true;

        for (int i = 0; i < n - 1 && swapped; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 6, 1, 2, 9, 1, 8, 2, 10, 40, 23, 1, 43, 15};

        Bubble.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
