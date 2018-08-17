package hash_map.types;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountMap<T> {
    private Map<T, Integer> map;

    public CountMap() {
        map = new HashMap<>();
    }

    public Integer add(T key) {
        return map.compute(key, (k, v) -> v == null ? 1 : v + 1);
    }

    public void remove(T key) {
        if (map.containsKey(key)) {
            Integer value = map.get(key);
            if (value == 1) {
                map.remove(key);
            } else {
                map.computeIfPresent(key, (k, v) -> v--);
            }
        }
    }

    public Integer get(T key) {
        return map.getOrDefault(key, 0);
    }

    public boolean containsKey(T key) {
        return map.containsKey(key);
    }

    public Set<T> keySet() {
        return map.keySet();
    }

    public int size() {
        return map.size();
    }
}
