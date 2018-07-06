package sorting.exercises.exercise_14;

import java.util.Arrays;

/**
 * Given an array of english characters, sort them in linear time
 */
public class Solution {
    /**
     * Counting sort
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public void solve1(char[] array) {
        // 26 characters in english alphabet (lower and upper cases)
        int[] counts = new int[52];

        for (char c : array) {
            int i;

            if (c >= 'a' && c <= 'z') {
                i = c - 'a';
            } else if (c >= 'A' && c <= 'Z') {
                i = c - 'Z' + 26;
            } else {
                throw new IllegalArgumentException("Char " + c + " is not a letter");
            }
            counts[i]++;
        }

        int k = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            int increment = i < 26 ? 'a' : 'Z' - 26;
            char c = (char) (increment + i);
            for (int j = 0; j < count; j++) {
                array[k++] = c;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] array = {'f', 'g', 'q', 'a', 't', 'j', 'k', 'b', 'e', 'd'};

        solution.solve1(array);

        System.out.println(Arrays.toString(array));
    }
}
