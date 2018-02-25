package Chapter8.Parenthesis;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis2 {
    public static void main(String[] args) {
        ArrayList<String> list = generateParenthesis(4);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void addParenthesit(List<String> list, int leftRem, int rightRem, char[] str, int index) {
        if (leftRem < 0 || rightRem < leftRem) {
            return;
        }
        if (rightRem == 0 && leftRem == 0) {
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '(';
            addParenthesit(list, leftRem - 1, rightRem, str, index + 1);
            str[index] = ')';
            addParenthesit(list, leftRem, rightRem - 1, str, index + 1);
        }
    }

    public static ArrayList<String> generateParenthesis(int count) {
        char[] str = new char[count * 2];
        ArrayList<String> list = new ArrayList<>();
        addParenthesit(list, count, count, str, 0);
        return list;
    }
}
