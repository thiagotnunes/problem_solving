package searching.problems.exercise_22;

import util.Pair;

/**
 * Search for an element in a 2-d sorted array
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n^2)
     * Space complexity - O(1)
     */
    public Pair solve1(int[][] array, int e) {
        int n = array.length;
        int m = array[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == e) {
                    return new Pair(i, j);
                }
            }
        }

        return null;
    }
}
