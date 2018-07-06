package sorting.exercises.exercise_15;

import java.util.Random;

/**
 * Given an array of strings, sort them so all the anagrams are
 * close to each other
 */
public class Solution {
    /**
     * Counting sort on each string + Quicksort on all strings
     * n - is the number of strings
     * m - is the average number of characters in the strings
     * k - is always 128, considering ASCII table (this could be removed from the O notation)
     * Time complexity - O(nlogn + m + k)
     * Space complexity - O(logn + k)
     */
    public void solve1(char[][] strings) {
        for (char[] string : strings) {
            countingSort(string);
        }

        quickSort(strings);
    }

    private void countingSort(char[] chars) {
        int[] counts = new int[128];

        for (int i = 0; i < chars.length; i++) {
            counts[chars[i]]++;
        }

        int k = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            for (int j = 0; j < count; j++) {
                chars[k++] = (char) i;
            }
        }
    }

    private void quickSort(char[][] strings) {
        quickSort(strings, 0, strings.length - 1, new Random());
    }

    private void quickSort(char[][] strings, int lo, int hi, Random random) {
        if (lo >= hi) return;

        int p = partition(strings, lo, hi, random);
        quickSort(strings, lo, p - 1, random);
        quickSort(strings, p + 1, hi, random);
    }

    private int partition(char[][] strings, int lo, int hi, Random random) {
        int pivotI = random.nextInt(hi - lo + 1) + lo;
        char[] pivot = strings[pivotI];
        strings[pivotI] = strings[hi];
        strings[hi] = pivot;

        int i = lo;
        int j = i;
        while (j < hi) {
            if (less(strings[j], pivot)) {
                char[] tmp = strings[i];
                strings[i] = strings[j];
                strings[j] = tmp;
                i++;
            }
            j++;
        }

        strings[hi] = strings[i];
        strings[i] = pivot;

        return i;
    }

    private boolean less(char[] s1, char[] s2) {
        int n = s1.length;
        int m = s2.length;
        int lim = Math.min(n, m);

        int i = 0;
        while (i < lim) {
            char c1 = s1[i];
            char c2 = s2[i];
            if (c1 != c2) {
                return c1 < c2;
            }
            i++;
        }
        return n < m;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] strings = {
                "a".toCharArray(),
                "lala".toCharArray(),
                "abcd".toCharArray(),
                "alal".toCharArray(),
                "bacd".toCharArray(),
                "cdba".toCharArray()
        };

        solution.solve1(strings);

        for (char[] string : strings) {
            System.out.println(string);
        }
    }
}
