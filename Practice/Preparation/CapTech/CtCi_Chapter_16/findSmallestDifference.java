package Preparation.CapTech.CtCi_Chapter_16;

import java.util.Arrays;

public class findSmallestDifference {
    public static void main(String[] args) {
        int[] a = {1, 2, 11, 16};
        int[] b = {4, 16, 19, 23, 127, 235};
        System.out.println(smallestDiffernce(a, b));
    }

    public static int smallestDiffernce(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int a = 0;
        int b = 0;
        int diff = Integer.MAX_VALUE;
        while (a < arr1.length && b < arr2.length) {
            if (Math.abs(arr1[a] - arr2[b]) < diff) {
                diff = Math.abs(arr1[a] - arr2[b]);
            }
            if (arr1[a] < arr2[b]) {
                a++;
            } else {
                b++;
            }
        }
        return diff;
    }
}
