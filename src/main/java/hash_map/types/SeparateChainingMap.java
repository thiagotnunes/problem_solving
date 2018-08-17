package hash_map.types;

import java.lang.reflect.Array;

public class SeparateChainingMap<K, V> implements IMap<K, V> {
    private class MapNode {
        private K key;
        private V value;
        private MapNode next;

        MapNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    private int capacity;
    private int size;
    private MapNode[] keyValues;

    @SuppressWarnings("unchecked")
    public SeparateChainingMap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.keyValues = (MapNode[]) Array.newInstance(MapNode.class, capacity);
    }

    @Override
    public boolean insert(K key, V value) {
        if (key == null || value == null) return false;

        int hashCode = key.hashCode() % capacity;
        MapNode node = new MapNode(key, value);
        if (keyValues[hashCode] == null) {
            keyValues[hashCode] = node;
        } else {
            MapNode current = keyValues[hashCode];
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        this.size++;

        return true;
    }

    @Override
    public boolean delete(K key) {
        if (size == 0 || key == null) return false;

        int hashCode = key.hashCode() % capacity;
        MapNode current = keyValues[hashCode];

        if (current == null) {
            return false;
        } else if (key.equals(current.key)) {
            keyValues[hashCode] = current.next;
            return true;
        } else {
            while (current.next != null) {
                if (key.equals(current.next.key)) {
                    current.next = current.next.next;
                    return true;
                }
                current = current.next;
            }
        }

        return false;
    }

    @Override
    public V search(K key) {
        if (size == 0 || key == null) return null;

        int hashCode = key.hashCode() % capacity;
        MapNode current = keyValues[hashCode];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        IMap<String, Integer> map = new SeparateChainingMap<>(101);

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
