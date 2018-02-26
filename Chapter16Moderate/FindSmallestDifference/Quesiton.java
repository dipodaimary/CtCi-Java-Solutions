package Chapter16Moderate.FindSmallestDifference;

import java.util.Arrays;

public class Quesiton {
    public static int smallestDifference(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int a = 0;
        int b = 0;
        int difference = Integer.MAX_VALUE;
        while (a < arr1.length && b < arr2.length) {
            if (Math.abs(arr1[a] - arr2[b]) < difference) {
                difference = Math.abs(arr1[a] - arr2[b]);
            }
            if (arr1[a] < arr2[b]) {
                a++;
            } else {
                b++;
            }
        }
        return difference;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {3, 4, 6, 2, 56, 7, 5};
        System.out.println(smallestDifference(arr1, arr2));
    }
}
