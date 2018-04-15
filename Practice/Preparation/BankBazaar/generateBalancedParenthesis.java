package Preparation.BankBazaar;

import java.util.ArrayList;

public class generateBalancedParenthesis {
    public static void main(String[] args) {
        ArrayList<String> ans = generateParenthesis(5);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static ArrayList<String> generateParenthesis(int n) {
        char[] str = new char[2 * n];
        ArrayList<String> list = new ArrayList<>();
        addParenthesis(list, n, n, str, 0);
        return list;
    }

    private static void addParenthesis(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
        if (leftRem < 0 || leftRem > rightRem) {
            return;//invalid state
        } else if (leftRem == 0 && rightRem == 0) {
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '(';//Add left and recurse
            addParenthesis(list, leftRem - 1, rightRem, str, index + 1);
            str[index] = ')';//Add right and recurse
            addParenthesis(list, leftRem, rightRem - 1, str, index + 1);
        }
    }
}
