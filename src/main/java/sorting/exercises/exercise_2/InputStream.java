package sorting.exercises.exercise_2;

public class InputStream {
    private final int[] array;
    private int i;

    public InputStream(int[] array) {
        this.array = array;
    }

    public int readNumber() {
        return i < array.length ? array[i++] : Integer.MAX_VALUE;
    }
}
