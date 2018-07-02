package sorting.types;

import java.util.Arrays;

/**
 * Selection sort
 * Worst case time complexity - O(n^2)
 * Average case time complexity - O(n^2)
 * Best case time complexity - O(n^2)
 * Space complexity - O(1)
 * Stable? - no
 */
public class Selection {
    public static void sort(int[] array) {
        int n = array.length;
        int min;

        for (int i = 0; i < n - 1; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int tmp = array[i];
            array[i] = array[min];
            array[min] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = {8, 1, 2, 6, 3, 4, 10, 11, 14, 20, 14, 3, 2, 1};

        Selection.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
