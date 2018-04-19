package Preparation.Flipkart;

import java.util.Arrays;

public class KeyPair {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 23, 21, 43};
        System.out.println(keyPair(arr, 5));
    }

    public static boolean keyPair(int[] arr, int sum) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int y = sum - arr[i];
            int index = Arrays.binarySearch(arr, y);
            if (index > -1) {
                return true;
            }
        }
        return false;
    }
}
