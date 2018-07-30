package priority_queue.types;

public class MaxHeap {

    private int length;
    private final int capacity;
    private final int[] heap;

    private MaxHeap(int[] array) {
        this.length = array.length;
        this.capacity = array.length;
        this.heap = array;
    }

    // O(n)
    public static MaxHeap heapify(int[] array) {
        int n = array.length;

        for (int i = n / 2; i >= 0; i--) {
            siftDown(array, n, i);
        }

        return new MaxHeap(array);
    }

    // O(logn)
    public int extractMax() {
        if (isEmpty()) throw new RuntimeException("heap is empty");

        int max = heap[0];
        heap[0] = heap[--length];
        heap[length] = max;
        siftDown(heap, length, 0);

        return max;
    }

    // O(1)
    public int getMax() {
        if (isEmpty()) throw new RuntimeException("heap is empty");

        return heap[0];
    }

    // O(logn)
    public void add(int e) {
        if (length == capacity) throw new RuntimeException("heap is full");

        heap[length] = e;
        siftUp(heap, length);
        length++;
    }

    // O(1)
    public boolean isEmpty() {
        return length == 0;
    }

    // O(1)
    public int size() {
        return length;
    }

    // O(logn)
    private static void siftDown(int[] array, int size, int i) {
        if (i >= size) return;

        int leftI = 2 * i + 1;
        int rightI = 2 * i + 2;
        int parent = array[i];
        int left = leftI < size ? array[leftI] : Integer.MIN_VALUE;
        int right = rightI < size ? array[rightI] : Integer.MIN_VALUE;
        int max = Math.max(left, right);

        if (max > parent && max == left) {
            array[i] = left;
            array[leftI] = parent;
            siftDown(array, size, leftI);
        } else if (max > parent && max == right) {
            array[i] = right;
            array[rightI] = parent;
            siftDown(array, size, rightI);
        }
    }

    private static void siftUp(int[] array, int i) {
        if (i <= 0) return;

        int parentI = (int) Math.ceil(i / 2.0) - 1;
        int parent = array[parentI];
        int current = array[i];

        if (current > parent) {
            array[parentI] = current;
            array[i] = parent;
            siftUp(array, parentI);
        }
    }
}
