package sorting.exercises.exercise_2;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given K sorted int input streams, make one fully sorted output stream
 */
public class Solution {
    /**
     * Heap
     * n - max size of an input stream
     * m - the number of input streams
     * Time complexity - O(nlogn)
     * Space complexity - O(n*m)
     */
    public OutputStream solve1(InputStream[] streams) {
        return new OutputStream() {
            private final Queue<Integer> heap = new PriorityQueue<>();

            @Override
            public boolean writeNumber() {
                for (InputStream is : streams) {
                    int number = is.readNumber();
                    if (number < Integer.MAX_VALUE) {
                        heap.add(number);
                    }
                }

                System.out.println(heap.remove());

                return !heap.isEmpty();
            }
        };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        OutputStream outputStream = solution.solve1(new InputStream[]{
                new InputStream(new int[]{1, 2, 3, 4, 5}),
                new InputStream(new int[]{3, 4, 5, 6, 7}),
                new InputStream(new int[]{1, 4, 6, 10})
        });

        while (outputStream.writeNumber());
    }
}
