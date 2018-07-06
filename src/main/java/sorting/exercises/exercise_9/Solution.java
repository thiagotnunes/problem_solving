package sorting.exercises.exercise_9;

/**
 * Heap sort
 * Pros:
 *  + Time complexity is always O(nlogn)
 *  + In place
 *  + Space complexity is O(1)
 * Cons:
 *  - Not stable
 * When to use:
 *  - Space is a concern
 *  - Stability is NOT a concern
 *  - O(nlogn) worst case is enough
 *  - O(nlogn) average case is enough
 *  - O(nlogn) best case is enough
 *
 * Merge sort
 * Pros:
 *  + Time complexity is always O(nlogn)
 *  + Stable
 * Cons:
 *  - Space complexity is O(n)
 *  - Not in place
 *  - Usually slower than quicksort due to copying phase
 * When to use:
 *  - Space is NOT a concern
 *  - Stability is a concern
 *  - O(nlogn) worst case is enough
 *  - O(nlogn) average case is enough
 *  - O(nlogn) best case is enough
 *
 * Quick sort
 * Pros:
 *  + Average case time complexity is O(nlogn)
 *  + Space complexity is O(logn) for the stack
 *  + Part of it can be executed for QuickSelect algorithm
 *  + In place
 * Cons:
 *  - Worst case time complexity is O(n^2)
 *  - Not stable
 * When to use:
 *  - Space is a concern
 *  - Stability is NOT a concern
 *  - O(n^2) worst case is enough
 *  - O(nlogn) average case is enough
 *  - O(nlogn) best case is enough
 *
 * Insertion sort
 * Pros:
 *  + Has small constant, so for small arrays it performs better
 *  than quick and merge sort
 *  + In place
 *  + Space complexity is O(1)
 * Cons:
 *  - Time complexity is O(n^2) in average case
 * When to use:
 *  - Space is a concern
 *  - Stability is a concern
 *  - O(n^2) worst case is enough
 *  - O(n^2) average case is enough
 *  - O(n) best case is enough
 *  - Array is small
 *  - Array is almost sorted
 *
 * Bubble sort
 * Pros:
 *  + Ease of implementation
 *  + In place
 *  + Space complexity is O(1)
 *  + Stable
 * Cons:
 *  - Time complexity is O(n^2) in average case
 * When to use:
 *  - Space is a concern
 *  - Stability is a concern
 *  - O(n^2) worst case is enough
 *  - O(n^2) average case is enough
 *  - O(n^2) best case is enough
 *  - Array is small
 *  - Array is almost sorted
 */
public class Solution {
}
