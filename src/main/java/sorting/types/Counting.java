package sorting.types;

import java.util.Arrays;

/**
 * Counting sort
 * Only possible for arrays of ints
 * Worst case time complexity - O(n + k)
 * Average case time complexity - O(n + k)
 * Best case time complexity - O(n + k)
 * Space complexity - O(k)
 */
public class Counting {
    public static void sort(int[] array, int k) {
        int[] counts = new int[k + 1];

        for (int e : array) {
            counts[e]++;
        }

        int l = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < counts[i]; j++) {
                array[l++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 4, 6, 3, 7, 2, 8, 1, 9};

        Counting.sort(array, 9);

        System.out.println(Arrays.toString(array));
    }
}
