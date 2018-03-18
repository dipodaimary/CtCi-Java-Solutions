package Chapter1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //System.out.println(isUnique("dipod"));
        System.out.println(isPermutation("dipo", "opid"));
    }

    public static boolean isUnique(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            } else {
                checker |= (1 << val);
            }
        }
        return true;
    }

    public static boolean isPermutation(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        String stra = new String(arr1);
        String strb = new String(arr2);
        return stra.equals(strb);
    }
}
