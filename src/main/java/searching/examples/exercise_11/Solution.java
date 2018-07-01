package searching.examples.exercise_11;

/**
 * Separate odd and even numbers in the array
 */
public class Solution {
    /**
     * Brute force
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public int[] solve1(int[] array) {
        int j = 0;
        int[] separated = new int[array.length];

        for (int element : array) {
            if (element % 2 == 0) {
                separated[j++] = element;
            }
        }

        for (int element : array) {
            if (element % 2 != 0) {
                separated[j++] = element;
            }
        }

        return separated;
    }

    /**
     * With pointers
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int[] solve2(int[] array) {
        int evens = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                int tmp = array[evens];
                array[evens] = array[i];
                array[i] = tmp;
                evens++;
            }
        }

        return array;
    }

    /**
     * Counting sort - only possible if we know the range of values
     * Time complexity - O(n + k)
     * Space complexity - O(k)
     */
    public int[] solve3(int[] array, int k) {
        int[] counts = new int[k];

        for (int element : array) {
            counts[element]++;
        }

        int j = 0;
        for (int i = 0; i < counts.length; i += 2) {
            int count = counts[i];
            for (int l = 0; l < count; l++, j++) {
                array[j] = i;
            }
        }
        for (int i = 1; i < counts.length; i += 2) {
            int count = counts[i];
            for (int l = 0; l < count; l++, j++) {
                array[j] = i;
            }
        }

        return array;
    }

    /**
     * With even and odd pointer
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int[] solve4(int[] array) {
        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            if (array[i] % 2 == 0) {
                i++;
            } else if (array[j] % 2 != 0) {
                j--;
            } else {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        return array;
    }
}
