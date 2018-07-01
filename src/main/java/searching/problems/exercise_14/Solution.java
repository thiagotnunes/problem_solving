package searching.problems.exercise_14;

import java.util.Arrays;

/**
 * Find median of two sorted arrays
 * TODO: Implement algorithm with sublinear solution
 */
public class Solution {
    /**
     * Brute force - with sorting
     * Time complexity - O((n + m)log(n + m))
     * Space complexity - O(n + m)
     */
    public int solve1(int[] array1, int[] array2) {
        int[] newArray = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, newArray, 0, array1.length);
        System.arraycopy(array2, 0, newArray, array1.length, array2.length);

        Arrays.sort(newArray);

        return newArray[newArray.length / 2];
    }

    /**
     * Merging
     * Time complexity - O(n + m)
     * Space complexity - O(n + m)
     */
    public int solve2(int[] array1, int[] array2) {
        int[] newArray = new int[array1.length + array2.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < array1.length || j < array2.length) {
            if (i == array1.length) {
                newArray[k++] = array2[j++];
            } else if (j == array2.length) {
                newArray[k++] = array1[i++];
            } else if (array1[i] < array2[j]) {
                newArray[k++] = array1[i++];
            } else {
                newArray[k++] = array2[j++];
            }
        }

        return newArray[newArray.length / 2];
    }
}
