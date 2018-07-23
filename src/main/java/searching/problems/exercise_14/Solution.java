package searching.problems.exercise_14;

import java.util.Arrays;

/**
 * Find median of two sorted arrays
 */
public class Solution {
    /**
     * Brute force - with sorting
     * Time complexity - O((n + m)log(n + m))
     * Space complexity - O(n + m)
     */
    public int solve1(int[] array1, int[] array2) {
        int[] newArray = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, newArray, 0, array1.length);
        System.arraycopy(array2, 0, newArray, array1.length, array2.length);

        Arrays.sort(newArray);

        return newArray[newArray.length / 2];
    }

    /**
     * Merging
     * Time complexity - O(n + m)
     * Space complexity - O(n + m)
     */
    public int solve2(int[] array1, int[] array2) {
        int[] newArray = new int[array1.length + array2.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < array1.length || j < array2.length) {
            if (i == array1.length) {
                newArray[k++] = array2[j++];
            } else if (j == array2.length) {
                newArray[k++] = array1[i++];
            } else if (array1[i] < array2[j]) {
                newArray[k++] = array1[i++];
            } else {
                newArray[k++] = array2[j++];
            }
        }

        return newArray[newArray.length / 2];
    }

    /**
     * Binary search
     * Time complexity - O(logn)
     * Space complexity - O(1)
     */
    public double solve3(int[] array1, int[] array2) {
        int n = array1.length;
        int m = array2.length;
        int minLength;
        int maxLength;
        int start;
        int end;
        int xLo;
        int xHi;
        int yLo;
        int yHi;

        if (n <= m) {
            minLength = n;
            maxLength = m;
        } else {
            int[] tmp = array1;
            array1 = array2;
            array2 = tmp;
            minLength = m;
            maxLength = n;
        }

        start = 0;
        end = minLength;
        while (true) {
            int partition1 = (start + end) / 2;
            int partition2 = (minLength + maxLength + 1) / 2 - partition1;
            xLo = partition1 > 0 ? array1[partition1 - 1] : Integer.MIN_VALUE;
            xHi = partition1 < minLength ? array1[partition1] : Integer.MAX_VALUE;
            yLo = partition2 > 0 ? array2[partition2 - 1] : Integer.MIN_VALUE;
            yHi = partition2 < maxLength ? array2[partition2] : Integer.MAX_VALUE;

            if (xLo <= yHi && yLo <= xHi) {
                break;
            } else if (xLo > yHi) {
                end = partition1 - 1;
            } else {
                start = partition1 + 1;
            }
        }

        if ((minLength + maxLength) % 2 == 0) {
            return (Math.max(xLo, yLo) + Math.min(xHi, yHi)) / 2.0;
        } else {
            return Math.max(xLo, yLo);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] array1 = new int[]{23, 26, 31, 35};
        int[] array2 = new int[]{3, 5, 7, 9, 11, 16};

        System.out.println(solution.solve3(array1, array2));
    }
}
