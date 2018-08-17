package hash_map.types;

import util.Pair;

import java.util.function.Function;

public class OpenAddressingMap<K, V> implements IMap<K, V> {
    private static int EMPTY = 0;
    private static int DELETED = 1;
    private static int FILLED = 2;

    private int capacity;
    private int size;
    private int[] state;
    private Pair<K, V>[] keyValues;
    private Function<Integer, Integer> conflictResolver;

    @SuppressWarnings("unchecked")
    public OpenAddressingMap(int capacity, Function<Integer, Integer> conflictResolver) {
        this.capacity = capacity;
        this.size = 0;
        this.state = new int[capacity];
        this.keyValues = new Pair[capacity];
        this.conflictResolver = conflictResolver;
    }

    @Override
    public boolean insert(K key, V value) {
        if (size == capacity) return false;

        int hashCode = key.hashCode() % capacity;
        for (int i = 0; i < capacity; i++) {
            if (state[hashCode] != FILLED) {
                keyValues[hashCode] = new Pair<>(key, value);
                state[hashCode] = FILLED;
                size++;
                return true;
            } else {
                hashCode = conflictResolver.apply(hashCode) % capacity;
            }
        }

        return false;
    }

    @Override
    public boolean delete(K key) {
        if (size == 0) return false;

        int pos = findByKey(key);
        if (pos >= 0 && state[pos] == FILLED) {
            state[pos] = DELETED;
            size--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public V search(K key) {
        if (size == 0) return null;

        int pos = findByKey(key);
        if (pos >= 0 && state[pos] == FILLED) {
            return keyValues[pos].second;
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    private int findByKey(K key) {
        int hashCode = key.hashCode() % capacity;
        for (int i = 0; i < capacity; i++) {
            if (state[hashCode] == EMPTY) {
                return -1;
            } else if (keyValues[hashCode].first.equals(key)) {
                return hashCode;
            } else {
                hashCode = conflictResolver.apply(hashCode) % capacity;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Function<Integer, Integer> linearProbing = (hashCode) -> hashCode + 1;
        Function<Integer, Integer> quadraticProbing = (hashCode) -> hashCode == 0 || hashCode == 1 ? hashCode + 1 : hashCode * hashCode;
        IMap<String, Integer> map = new OpenAddressingMap<>(101, linearProbing);

        map.insert("abc", 10);
        map.insert("def", 2);
        map.insert("ghj", 5);

        System.out.println();
        System.out.println("Search after Insert");
        System.out.println(map.search("abc"));
        System.out.println(map.search("def"));
        System.out.println(map.search("ghj"));

        System.out.println();
        System.out.println("Delete");
        System.out.println(map.delete("def"));
        System.out.println(map.delete("def"));
        System.out.println(map.delete("abc"));

        System.out.println();
        System.out.println("Search after delete");
        System.out.println(map.search("abc"));
        System.out.println(map.search("def"));
        System.out.println(map.search("ghj"));
    }
}
