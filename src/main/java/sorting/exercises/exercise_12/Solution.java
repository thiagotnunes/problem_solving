package sorting.exercises.exercise_12;

import java.util.Arrays;

/**
 * Merge two sorted arrays into one sorted array
 */
public class Solution {
    /**
     * Sorting
     * Time complexity - O(nlogn)
     * Space complexity - O(n)
     */
    public int[] solve1(int[] array1, int[] array2) {
        int n = array1.length;
        int m = array2.length;
        int[] merged = new int[n + m];

        System.arraycopy(array1, 0, merged, 0, n);
        System.arraycopy(array2, 0, merged, n, m);

        Arrays.sort(merged);

        return merged;
    }

    /**
     * Merge (from merge sort)
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public int[] solve2(int[] array1, int[] array2) {
        int n = array1.length;
        int m = array2.length;
        int[] merged = new int[n + m];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n || j < m) {
            if (i >= n) {
                merged[k] = array2[j++];
            } else if (j >= m) {
                merged[k] = array1[i++];
            } else if (array1[i] <= array2[j]) {
                merged[k] = array1[i++];
            } else {
                merged[k] = array2[j++];
            }
            k++;
        }

        return merged;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] merged = solution.solve2(new int[]{1, 3, 5, 7, 9}, new int[]{2, 4, 6, 8});

        System.out.println(Arrays.toString(merged));
    }
}
