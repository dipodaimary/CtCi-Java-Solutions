package Chapter16_Moderate;

import java.util.Arrays;

public class Q16_SmallestDifference {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 15, 11, 2};
        int[] array2 = {23, 127, 234, 19, 8};
        System.out.println(findSmallestDifference(array1, array2));
    }

    public static int findSmallestDifference(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        int smallestDifference = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        while (a < array1.length && b < array2.length) {
            if (Math.abs(array1[a] - array2[b]) < smallestDifference) {
                smallestDifference = Math.abs(array1[a] - array2[b]);
            }
            //Move the smallest number
            if (array1[a] < array2[b]) {
                a++;
            } else {
                b++;
            }
        }
        return smallestDifference;
    }
}
