package searching.problems.exercise_21;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Remove duplicates in an integer array
 */
public class Solution {
    /**
     * HashSet
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public void solve1(int[] array) {
        int n = array.length;
        HashSet<Integer> seen = new HashSet<>();

        for (int e : array) {
            seen.add(e);
        }

        Iterator<Integer> it = seen.iterator();
        for (int i = 0; i < seen.size(); i++) {
            array[i] = it.next();
        }
        for (int i = seen.size(); i < n; i++) {
            array[i] = Integer.MIN_VALUE;
        }
    }

    /**
     * Sorting
     * Time complexity - O(nlogn)
     * Space complexity - O(n)
     */
    public void solve2(int[] array) {
        int n = array.length;
        int[] noDuplicates = new int[n];
        Arrays.sort(array);

        for (int i = 0; i < n; i++) {
            noDuplicates[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < n; i++) {
            if (noDuplicates[i - 1] != array[i]) {
                noDuplicates[i] = array[i];
            }
        }

        System.arraycopy(noDuplicates, 0, array, 0, n);
    }

    /**
     * Counting sort - only possible if the range is given
     * Time complexity - O(n + k)
     * Space complexity - O(k)
     */
    public void solve3(int[] array, int k) {
        int n = array.length;
        int[] counts = new int[k];

        for (int i = 0; i < k; i++) {
            counts[array[i]]++;
        }

        int j = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) array[j++] = i;
        }
        for (; j < n; j++) {
            array[j] = Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] array = {5, 3, 5, 9, 2, 3, 4, 6, 5, 1, 2};
        solution.solve3(array, 10);
        System.out.println(Arrays.toString(array));
    }
}
