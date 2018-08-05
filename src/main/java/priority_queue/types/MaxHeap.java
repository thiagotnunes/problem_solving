package priority_queue.types;

public class MaxHeap {

    private int length;
    private int capacity;
    private int[] heap;

    private MaxHeap(int[] heap, int length, int capacity) {
        this.length = length;
        this.capacity = capacity;
        this.heap = heap;
    }

    public static MaxHeap create(int capacity) {
        return new MaxHeap(new int[capacity], 0, capacity);
    }

    // O(n)
    public static MaxHeap heapify(int[] array) {
        int n = array.length;

        for (int i = n / 2; i >= 0; i--) {
            siftDown(array, n, i);
        }

        return new MaxHeap(array, n, n);
    }

    // O(logn)
    public int extract() {
        if (isEmpty()) throw new RuntimeException("heap is empty");
        if (length < capacity / 3) shrink();

        int max = heap[0];
        heap[0] = heap[--length];
        heap[length] = max;
        siftDown(heap, length, 0);

        return max;
    }

    // O(1)
    public int peek() {
        if (isEmpty()) throw new RuntimeException("heap is empty");

        return heap[0];
    }

    // O(logn)
    public void add(int e) {
        if (length == capacity) expand();

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

    // O(1)
    public int[] getArray() {
        return heap;
    }

    // O(n)
    private void expand() {
        int newCapacity = capacity * 2;
        int[] newHeap = new int[newCapacity];

        System.arraycopy(heap, 0, newHeap, 0, capacity);

        capacity = newCapacity;
        heap = newHeap;
    }

    // O(n)
    private void shrink() {
        int newCapacity = capacity / 2;
        int[] newHeap = new int[newCapacity];

        System.arraycopy(heap, 0, newHeap, 0, newCapacity);

        capacity = newCapacity;
        heap = newHeap;
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
        } else if (max > parent) {
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
