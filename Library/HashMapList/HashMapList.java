package HashMapList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapList<T, E> {
    HashMap<T, ArrayList<E>> map = new HashMap<>();

    public void put(T key, E item) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<E>());
        }
        map.get(key).add(item);
    }

    public void put(T key, ArrayList<E> items) {
        map.put(key, items);
    }

    public ArrayList<E> get(T key) {
        return map.get(key);
    }

    public boolean containsKeyValue(T key, E value) {
        ArrayList<E> list = map.get(key);
        return list.contains(value);
    }

    public boolean containsKey(T key) {
        return map.containsKey(key);
    }

    public Set<T> keySet() {
        return map.keySet();
    }
}
