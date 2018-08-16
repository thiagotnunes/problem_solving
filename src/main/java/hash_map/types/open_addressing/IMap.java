package hash_map.types.open_addressing;

public interface IMap<K, V> {
    boolean insert(K key, V value);

    boolean delete(K key);

    V search(K key);

    int size();
}
