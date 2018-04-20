package Preparation.CapTech;

import java.util.Arrays;

public class C1Q1_isUnique {
    public static void main(String[] args) {
        System.out.println(isUnique("dipod"));
    }

    public static boolean isUnique(String str) {
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
}
