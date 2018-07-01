package searching.problems.exercise_20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Check if two arrays are permutations of one another
 */
public class Solution {
    /**
     * Sorting - only possible if we can mutate the arrays
     * Time complexity - O(nlogn)
     * Space complexity - O(1)
     */
    public boolean solve1(int[] array1, int[] array2) {
        int n = array1.length;
        int m = array2.length;

        if (n != m) return false;

        Arrays.sort(array1);
        Arrays.sort(array2);

        for (int i = 0; i < n; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * HashMap
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public boolean solve2(int[] array1, int[] array2) {
        int n = array1.length;
        int m = array2.length;

        if (n != m) return false;

        HashMap<Integer, Integer> map1 = new HashMap<>(n);
        HashMap<Integer, Integer> map2 = new HashMap<>(m);

        for (int i = 0; i < n; i++) {
            map1.compute(array1[i], (key, value) -> value == null ? 1 : value + 1);
            map2.compute(array2[i], (key, value) -> value == null ? 1 : value + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            Integer key1 = entry.getKey();
            Integer value1 = entry.getValue();
            if (!value1.equals(map2.get(key1))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Counting sort - only possible if the range of values is known
     * Time complexity - O(n + k)
     * Space complexity - O(k)
     */
    public boolean solve3(int[] array1, int[] array2, int k) {
        int n = array1.length;
        int m = array2.length;

        if (n != m) return false;

        int[] counts1 = new int[k];
        int[] counts2 = new int[k];

        for (int i = 0; i < k; i++) {
            counts1[array1[i]]++;
            counts2[array2[i]]++;
        }
        for (int i = 0; i < k; i++) {
            if (counts1[i] != counts2[i]) {
                return false;
            }
        }

        return true;
    }
}
