package Preparation.CapTech;

import java.util.Arrays;

public class C1Q1_isUnique {
    public static void main(String[] args) {
        System.out.println(isUnique("dipo"));
    }

    public static boolean isUniqueOld(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] charSet = new boolean[128];
        for (char c : str.toCharArray()) {
            if (charSet[c]) {
                return false;
            }
            charSet[c] = true;
            System.out.println(Arrays.toString(charSet));
        }
        return true;
    }

    public static boolean isUnique(String str) {
        int checker = 0;
        for (char c : str.toCharArray()) {
            int val = c - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= 1 << val;
        }
        return true;
    }
}
