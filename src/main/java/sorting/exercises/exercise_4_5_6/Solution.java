package sorting.exercises.exercise_4_5_6;

/**
 * Exercise 4: How would you sort 1PB of numbers?
 *
 * This requires external sort:
 *  - We can load into memory a chunk of numbers and sort them.
 *  - After the chunks are sorted we need to merge them.
 *  We can use a priority queue to merge the chunks as in exercise 3
 *
 * For the sorting phase
 *  - If the range of numbers fits into memory, we can use counting sort
 *  (with longs to accumulate counts)
 *  - If the range of numbers do not fit into memory, we can use any other
 *  sort, like quick or merge sort.
 *
 * For the output
 *  - We can stream the merged numbers into the output file
 *
 *
 * Exercise 5: What is time complexity of the solution?
 *
 * Given there are K files with M numbers
 *  - Using counting sort O(K * M + K * M log K)
 *  - Using merge sort O(K * M log KM + K * M log K)
 *
 *
 * Exercise 6: Any improvements if the number of cores is 8?
 *
 * We can parallelize the sorting phase in the different cores.
 * The merge phase would still be sequential.
 */
public class Solution {
}
