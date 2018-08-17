package hash_map.exercises.exercise_2;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the most occurring word in a string
 */
public class Solution {
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public String solve1(String s) {
        Map<String, Integer> frequency = new HashMap<>();
        String maxWord = null;
        String[] split = s.split(" ");

        for (String word : split) {
            int newFrequency = frequency.getOrDefault(word, 0) + 1;
            frequency.put(word, newFrequency);
            if (newFrequency > frequency.getOrDefault(maxWord, 0)) {
                maxWord = word;
            }
        }

        return maxWord;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1("a b c d e f a d b s f d"));
    }
}
