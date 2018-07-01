package searching.problems.exercise_18;

import java.util.Arrays;

/**
 * Transform array, like this [a1, a2, a3, a4, b1, b2, b3, b4] to [a1, b1, a2, b2, a3, b3, a4, b4]
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public int[] solve1(int[] array) {
        int n = array.length / 2;
        int[] swapped = new int[array.length];

        int i = 0;
        int j = n;
        int k = 0;
        while (i < n) {
            swapped[k++] = array[i++];
            swapped[k++] = array[j++];
        }

        return swapped;
    }

    /**
     * [ 1 2 3 4 11 12 13 14 ]
     *   0 1 2 3 4  5  6  7
     *
     * [ 1 11 2 12 3 13 4 14 ]
     *   0 1  2 3  4 5  6 7
     */
    public int[] solve2(int[] array) {
        int n =  array.length / 2;
        int tmp;

        // i = 1 -> 3,4
        // i = 2 -> 2,3 / 4,5
        // i = 3 -> 1,2 / 3,4 / 5,6
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                tmp = array[n - i + 2 * j];
                array[n - i + 2 * j] = array[n - i + 2 * j + 1];
                array[n - i + 2 * j + 1] = tmp;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solve2(new int[]{1, 2, 3, 4, 11, 12, 13, 14})));
    }
}
