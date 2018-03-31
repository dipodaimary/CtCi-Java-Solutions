package Recursion;

import java.util.ArrayList;
import java.util.HashMap;

public class Q8_Permutations_With_Dups {
    public static void main(String[] args) {
        ArrayList<String> permutations = printPerms("aabc");
        for (int i = 0; i < permutations.size(); i++) {
            System.out.println(permutations.get(i));
        }
    }

    public static ArrayList<String> printPerms(String s) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<Character, Integer> map = buildFreqTable(s);
        printPerms(map, "", s.length(), result);
        return result;
    }

    private static void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
        //Base case permutations have been completed
        if (remaining == 0) {
            result.add(prefix);
            return;
        }
        //Try remaining characters
        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                printPerms(map, prefix + c, remaining - 1, result);
                map.put(c, count);
            }
        }
    }

    private static HashMap<Character, Integer> buildFreqTable(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        return map;
    }
}
