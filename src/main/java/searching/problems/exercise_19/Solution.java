package searching.problems.exercise_19;

/**
 * Find the 2nd largest element in an unsorted array with the minimum number of comparisons
 */
public class Solution {
    /**
     * Two pointer solution
     * Comparisons - n
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve1(int[] array) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int e : array) {
            if (e > max) {
                max2 = max;
                max = e;
            }
        }

        return max2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
