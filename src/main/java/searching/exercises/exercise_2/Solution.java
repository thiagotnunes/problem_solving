package searching.exercises.exercise_2;

import java.util.Arrays;

/**
 * Find three elements in the array which sum to a given value
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n^3)
     * Space complexity - O(1)
     */
    public int[] solve1(int[] array, int target) {
        for (int i = 0; i < array.length - 2; i++) {
            int e1 = array[i];
            for (int j = i + 1; j < array.length - 1; j++) {
                int e2 = array[j];
                for (int k = 0; k < array.length; k++) {
                    int e3 = array[k];
                    if (e1 + e2 + e3 == target) {
                        return new int[]{e1, e2, e3};
                    }
                }
            }
        }

        return null;
    }

    /**
     * Sorting - only possible if we can mutate the array
     * Time complexity - O(nlogn + n^2)
     * Space complexity - O(1)
     */
    public int[] solve2(int[] array, int target) {
        int n = array.length;

        Arrays.sort(array);

        for (int i = 0; i < n - 2; i++) {
            int e1 = array[i];

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int e2 = array[j];
                int e3 = array[k];
                int sum = e1 + e2 + e3;

                if (sum == target) {
                    return new int[]{e1, e2, e3};
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solve2(new int[]{3, 6, 4, 7, 2, 1, 5, 9, 8}, 17)));
    }
}
