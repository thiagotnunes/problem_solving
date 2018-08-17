package hash_map.examples.example_1;

import hash_map.types.CountMap;

import java.util.Set;

/**
 * Check if two strings are anagrams
 */
public class Solution {
    /**
     * Time complexity - O(n + m)
     * Space complexity - O(n + m)
     */
    public boolean solve1(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        CountMap<Character> map1 = new CountMap<>();
        CountMap<Character> map2 = new CountMap<>();

        for (Character c : s1.toCharArray()) {
            map1.add(c);
        }
        for (Character c : s2.toCharArray()) {
            map2.add(c);
        }

        Set<Character> c1 = map1.keySet();
        Set<Character> c2 = map2.keySet();

        if (c1.size() != c2.size()) {
            return false;
        } else if (!c1.containsAll(c2)) {
            return false;
        } else {
            for (Character c : c1) {
                if (!map1.get(c).equals(map2.get(c))) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Time complexity - O(n + m)
     * Space complexity - O(n)
     */
    public boolean solve2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        CountMap<Character> map = new CountMap<>();

        for (Character c : s1.toCharArray()) {
            map.add(c);
        }
        for (Character c : s2.toCharArray()) {
            map.remove(c);
        }

        return map.size() == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve2("abcdefg", "gfedcba"));
    }
}
