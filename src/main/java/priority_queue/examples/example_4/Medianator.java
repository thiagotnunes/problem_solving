package priority_queue.examples.example_4;

import priority_queue.types.MaxHeap;
import priority_queue.types.MinHeap;

/**
 * Provide median of given values in constant time
 */
public class Medianator {
    private MinHeap minHeap;
    private MaxHeap maxHeap;

    public Medianator() {
        minHeap = MinHeap.create(10);
        maxHeap = MaxHeap.create(10);
    }

    // O(logn)
    public void add(int e) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= e) {
            maxHeap.add(e);
        } else {
            minHeap.add(e);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            int max = maxHeap.extract();
            minHeap.add(max);
        } else if (minHeap.size() > maxHeap.size() + 1) {
            int min = minHeap.extract();
            maxHeap.add(min);
        }
    }

    // O(1)
    public double mean() {
        if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
        if (minHeap.size() > maxHeap.size()) return minHeap.peek();
        if (maxHeap.size() == 0) return Integer.MAX_VALUE;

        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {
        Medianator medianator = new Medianator();

        System.out.println(medianator.mean());
        medianator.add(1);
        System.out.println(medianator.mean());
        medianator.add(2);
        System.out.println(medianator.mean());
        medianator.add(3);
        System.out.println(medianator.mean());
        medianator.add(4);
        System.out.println(medianator.mean());
        medianator.add(5);
        System.out.println(medianator.mean());
    }
}
