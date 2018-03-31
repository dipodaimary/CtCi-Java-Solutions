package Recursion;

import java.util.ArrayList;

public class Q7_Permuations_Without_Dups {
    public static void main(String[] args) {
        ArrayList<String> permuations = getPerms2("abcd");
        for (int i = 0; i < permuations.size(); i++) {
            System.out.println(permuations.get(i).toString());
        }
    }

    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    public static ArrayList<String> getPerms(String str) {
        if (str == null) return null;
        ArrayList<String> permutations = new ArrayList<>();
        //Base Case
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }
        char first = str.charAt(0);//get the first char
        String remainder = str.substring(1);//remove the first character
        ArrayList<String> words = getPerms(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    public static ArrayList<String> getPerms2(String str) {
        ArrayList<String> result = new ArrayList<>();
        getPerms2("", str, result);
        return result;
    }

    private static void getPerms2(String prefix, String remainder, ArrayList<String> result) {
        if (remainder.length() == 0) {
            result.add(prefix);
        }
        int len = remainder.length();
        for (int i = 0; i < len; i++) {
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1, len);
            char c = remainder.charAt(i);
            getPerms2(prefix + c, before + after, result);
        }
    }
}
