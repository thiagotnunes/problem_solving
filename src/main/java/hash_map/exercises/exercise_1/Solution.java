package hash_map.exercises.exercise_1;

import java.util.HashSet;
import java.util.Set;

/**
 * Design a number generator that generate numbers between 0-99999999
 */
public class Solution {
    private Set<Integer> assigned;
    private int current;
    private int capacity;

    public Solution(int capacity) {
        this.assigned = new HashSet<>();
        this.capacity = capacity;
        this.current = 0;
    }

    /**
     * Returns the next available number.
     * Time complexity - O(n)
     */
    public int getNumber() {
        while (current < capacity && assigned.contains(current)) {
            current++;
        }

        if (current == capacity) {
            return -1;
        } else {
            assigned.add(current);
            return current;
        }
    }

    /**
     * Checks if the given number is assigned.
     * If it is assigned returns 0.
     * If it is not assigned, assigns it and returns 1.
     * Time complexity - O(1)
     */
    public int requestNumber(int number) {
        if (number >= capacity) return 0;

        if (assigned.contains(number)) {
            return 0;
        } else {
            assigned.add(number);
            return 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(3);
        System.out.println(solution.getNumber());
        System.out.println(solution.requestNumber(1));
        System.out.println(solution.getNumber());
        System.out.println(solution.getNumber());
    }
}
