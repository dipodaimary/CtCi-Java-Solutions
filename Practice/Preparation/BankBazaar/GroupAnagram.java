package Preparation.BankBazaar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static void sort(String[] array) {
        HashMapList<String, String> mapList = new HashMapList<>();
        for (String s : array) {
            String key = sortChars(s);
            mapList.put(key, s);
        }
        //convert hash table to array
        int index = 0;
        for (String key : mapList.keySet()) {
            ArrayList<String> list = mapList.get(key);
            for (String out : list) {
                array[index] = out;
                index++;
            }
        }
    }
}

class HashMapList<T, E> {
    private HashMap<T, ArrayList<E>> map = new HashMap<T, ArrayList<E>>();

    /* Insert item into list at key. */
    public void put(T key, E item) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<E>());
        }
        map.get(key).add(item);
    }

    /* Insert list of items at key. */
    public void put(T key, ArrayList<E> items) {
        map.put(key, items);
    }

    /* Get list of items at key. */
    public ArrayList<E> get(T key) {
        return map.get(key);
    }

    /* Check if hashmaplist contains key. */
    public boolean containsKey(T key) {
        return map.containsKey(key);
    }

    /* Check if list at key contains value. */
    public boolean containsKeyValue(T key, E value) {
        ArrayList<E> list = get(key);
        if (list == null) return false;
        return list.contains(value);
    }

    /* Get the list of keys. */
    public Set<T> keySet() {
        return map.keySet();
    }

    @Override
    public String toString() {
        return map.toString();
    }
}