package priority_queue.types;

public class MinHeap {
    private int length;
    private final int capacity;
    private final int[] heap;

    private MinHeap(int[] heap) {
        this.length = heap.length;
        this.capacity = heap.length;
        this.heap = heap;
    }

    // O(n)
    public static MinHeap heapify(int[] array) {
        int n = array.length;

        for (int i = n / 2; i >= 0; i--) {
            siftDown(array, n, i);
        }

        return new MinHeap(array);
    }

    // O(logn)
    public int extractMin() {
        if (isEmpty()) throw new RuntimeException("heap is empty");

        int min = heap[0];
        heap[0] = heap[--length];
        heap[length] = min;

        siftDown(heap, length, 0);

        return min;
    }

    // O(1)
    public int getMin() {
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
        int left = leftI < size ? array[leftI] : Integer.MAX_VALUE;
        int right = rightI < size ? array[rightI] : Integer.MAX_VALUE;
        int min = Math.min(left, right);

        if (min < parent && min == left) {
            array[i] = left;
            array[leftI] = parent;
            siftDown(array, size, leftI);
        } else if (min < parent && min == right) {
            array[i] = right;
            array[rightI] = parent;
            siftDown(array, size, rightI);
        }
    }

    // O(logn)
    private static void siftUp(int[] array, int i) {
        if (i <= 0) return;

        int parentI = (int) Math.ceil(i / 2.0) - 1;
        int parent = array[parentI];
        int current = array[i];

        if (current < parent) {
            array[parentI] = current;
            array[i] = parent;
            siftUp(array, parentI);
        }
    }
}
