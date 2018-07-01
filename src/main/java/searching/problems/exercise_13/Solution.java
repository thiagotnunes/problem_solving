package searching.problems.exercise_13;

import java.util.Arrays;
import java.util.Random;

/**
 * Find the median of an array
 */
public class Solution {
    private Random random;

    public Solution(Random random) {
        this.random = random;
    }

    /**
     * Sorting
     * Time complexity - O(nlogn)
     * Space complexity - O(1)
     */
    public int solve1(int[] array) {
        Arrays.sort(array);

        return array[array.length / 2];
    }

    /**
     * Quickselect
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public int solve2(int[] array) {
        return quickSelect(array, 0, array.length - 1);
    }

    private int quickSelect(int[] array, int low, int high) {
        if (low == high) return array[low];

        int pivotIndex = partition(array, low, high);

        if (pivotIndex == array.length / 2 - 1) {
            return array[pivotIndex];
        } else if (pivotIndex > array.length / 2 - 1) {
            return quickSelect(array, low, pivotIndex - 1);
        } else {
            return quickSelect(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivotIndex = low + random.nextInt(high - low + 1);
        int pivot = array[pivotIndex];
        array[pivotIndex] = array[high];
        array[high] = pivot;
        int boundary = low;
        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                int tmp = array[i];
                array[i] = array[boundary];
                array[boundary] = tmp;
                boundary++;
            }
        }
        array[high] = array[boundary];
        array[boundary] = pivot;

        return boundary;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 89, 321, 9, -10, 48, 10, 57, 12};
        System.out.println(new Solution(new Random()).solve2(array));

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
