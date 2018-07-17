package queue.examples.example_5;

import queue.types.ArrayQueue;
import queue.types.Queue;

/**
 * Josephus problem
 * There are n people in a queue.
 * k people are removed and re-added to queue.
 * The next person is executed.
 * The last one to survive is not executed.
 * Find the position to be in the queue to survive.
 */
public class Solution {
    /**
     * Queue based simulation
     * Time complexity - O(nk)
     * Space complexity - O(n)
     */
    public Integer solve1(int n, int k) {
        Queue<Integer> queue = new ArrayQueue<>(n);
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            for (int i = 0; i < k; i++) {
                queue.add(queue.remove());
            }
            Integer toExecute = queue.remove();
            System.out.println("Executing " + toExecute);
        }

        return queue.remove();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solve1(10, 3));
    }
}
