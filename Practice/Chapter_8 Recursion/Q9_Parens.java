package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Q9_Parens {
    public static void main(String[] args) {
        ArrayList<String> out = generateParensEfficient(3);
        for (String str : out) {
            System.out.println(str);
        }
    }

    public static Set<String> generateParens(int remaining) {
        Set<String> set = new HashSet<>();
        if (remaining == 0) {
            set.add("");
        } else {
            Set<String> prev = generateParens(remaining - 1);
            for (String str : prev) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = insertInside(str, i);
                        /*
                        Add s to set if it's not already in there. Note: HashSet
                        automatically checks for duplicates before adding, so an explicit check is not
                        needed
                         */
                        set.add(s);
                    }
                }
                set.add("()" + str);
            }
        }
        return set;
    }

    private static String insertInside(String str, int leftIndex) {
        String left = str.substring(0, leftIndex + 1);
        String right = str.substring(leftIndex + 1, str.length());
        System.out.println(left + "()" + right);
        return left + "()" + right;
    }

    private static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
        if (leftRem < 0 || rightRem < leftRem) return;//Invalid state
        if (leftRem == 0 && rightRem == 0) {
            /*out of left and right parentheses
             */
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '(';//Add left and recurse
            addParen(list, leftRem - 1, rightRem, str, index + 1);
            str[index] = ')';
            addParen(list, leftRem, rightRem - 1, str, index + 1);
        }
    }

    public static ArrayList<String> generateParensEfficient(int count) {
        char[] str = new char[count * 2];
        ArrayList<String> list = new ArrayList<>();
        addParen(list, count, count, str, 0);
        return list;
    }
}
