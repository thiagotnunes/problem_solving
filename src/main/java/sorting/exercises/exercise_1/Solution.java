package sorting.exercises.exercise_1;

import java.util.*;

/**
 * Given text, print the words with their frequencies
 */
public class Solution {
    private class Pair implements Comparable<Pair> {
        private final String word;
        private final Integer frequency;

        public Pair(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Pair other) {
            return frequency.compareTo(other.frequency);
        }
    }

    /**
     * Sorting
     * Time complexity - O(nlogn)
     * Space complexity - O(n)
     */
    public String solve1(String[] array, int k) {
        Map<String, Integer> frequencies = new HashMap<>();
        List<Pair> frequencyPairs = new ArrayList<>();

        // O(n)
        for (String word : array) {
            frequencies.compute(word, (key, value) -> value == null ? 1 : value + 1);
        }

        // O(n)
        for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
            frequencyPairs.add(new Pair(entry.getKey(), entry.getValue()));
        }

        // O(nlogn)
        Collections.sort(frequencyPairs);

        // O(n)
        for (Pair pair : frequencyPairs) {
            System.out.println(pair.word + " - " + pair.frequency);
        }

        // O(1)
        return frequencyPairs.get(k - 1).word;
    }

    /**
     * QuickSelect
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public String solve2(String[] array, int k) {
        Map<String, Integer> frequencies = new HashMap<>();
        List<Pair> frequencyPairs = new ArrayList<>();

        // O(n)
        for (String word : array) {
            frequencies.compute(word, (key, value) -> value == null ? 1 : value + 1);
        }

        // O(n)
        for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
            frequencyPairs.add(new Pair(entry.getKey(), entry.getValue()));
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        // O(n)
        Pair kth = quickSelect(frequencyPairs, 0, frequencyPairs.size() - 1, k, new Random());

        return kth == null ? null : kth.word;
    }

    /**
     * Heap
     * Time complexity - O(klogn)
     * Space complexity - O(n)
     */
    public String solve3(String[] array, int k) {
        Map<String, Integer> frequencies = new HashMap<>();
        PriorityQueue<Pair> frequencyPairs = new PriorityQueue<>();

        // O(n)
        for (String word : array) {
            frequencies.compute(word, (key, value) -> value == null ? 1 : value + 1);
        }

        // O(n)
        for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
            frequencyPairs.add(new Pair(entry.getKey(), entry.getValue()));
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        // O (klogn)
        for (int i = 0; i < k - 1; i++) {
            frequencyPairs.remove();
        }

        return frequencyPairs.remove().word;
    }

    private Pair quickSelect(List<Pair> pairs, int lo, int hi, int k, Random random) {
        if (lo > hi) return null;

        int pivotI = partition(pairs, lo, hi, random);
        if (pivotI == k - 1) {
            return pairs.get(pivotI);
        } else if (pivotI > k - 1) {
            return quickSelect(pairs, lo, pivotI - 1, k, random);
        } else {
            return quickSelect(pairs, pivotI + 1, hi, k, random);
        }
    }

    private int partition(List<Pair> pairs, int lo, int hi, Random random) {
        int pivotI = random.nextInt(hi - lo + 1) + lo;
        Pair pivot = pairs.get(pivotI);
        pairs.set(pivotI, pairs.get(hi));
        pairs.set(hi, pivot);

        int i = lo;
        int j = i;
        while (j < hi) { // Up to before pivot
            Pair pair = pairs.get(j);
            if (pair.compareTo(pivot) < 0) {
                Pair tmp = pairs.get(j);
                pairs.set(j, pairs.get(i));
                pairs.set(i, tmp);
                i++;
            }
            j++;
        }
        pairs.set(hi, pairs.get(i));
        pairs.set(i, pivot);

        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve3(new String[]{"a", "b", "b", "d", "a", "a", "b", "c", "d", "b"}, 4));
    }
}
