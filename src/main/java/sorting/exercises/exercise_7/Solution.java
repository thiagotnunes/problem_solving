package sorting.exercises.exercise_7;

import util.Pair;

/**
 * Given an array of integers that support findMin, findMax and findMedian,
 * sort the array
 * TODO: Finish the implementation
 */
public class Solution {
    private static class Array {
        private final int[] array;
        private final int length;

        public Array(int[] array) {
            this.array = array;
            this.length = array.length;
        }

        private Pair findMin(int lo, int hi) {
            int minI = lo;
            int min = array[minI];
            for (int i = lo + 1; i < hi; i++) {
                if (array[i] < min) {
                    min = array[i];
                    minI = i;
                }
            }

            return new Pair(min, minI);
        }

        private Pair findMedian(int lo, int hi) {
            return null;
        }

        private Pair findMax(int lo, int hi) {
            int maxI = lo;
            int max = array[maxI];
            for (int i = lo + 1; i < hi; i++) {
                if (array[i] > max) {
                    max = array[i];
                    maxI = i;
                }
            }

            return new Pair(max, maxI);
        }
    }
}
