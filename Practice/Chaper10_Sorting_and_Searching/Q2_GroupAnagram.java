package SortingAndSearching;

import java.util.Comparator;

import static java.util.Arrays.sort;


public class Q2_GroupAnagram implements Comparator<String> {
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    } 

    public static String sortChars(String s) {
        char[] content = s.toCharArray();
        sort(content);
        return new String(content);
    }

    @Override
    public int compare(String s1, String s2) {
        return sortChars(s1).compareTo(sortChars(s2));
    }
}
