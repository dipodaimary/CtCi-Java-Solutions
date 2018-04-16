package Preparation.Flipkart;

import java.util.Arrays;

/*
K-th Element of Two Sorted Arrays
Given two sorted arrays of size m and n respectively, you are tasked with finding the element that would be at the k’th position of the final sorted array.

Examples:

Input : Array 1 - 2 3 6 7 9
        Array 2 - 1 4 8 10
        k = 5
Output : 6
Explanation: The final sorted array would be -
1, 2, 3, 4, 6, 7, 8, 9, 10
The 5th element of this array is 6.
Input : Array 1 - 100 112 256 349 770
        Array 2 - 72 86 113 119 265 445 892
        k = 7
Output : 256
Explanation: Final sorted array is -
72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
7th element of this array is 256.
 */
public class KthElementOfTwoSortedArrays {
    public static void main(String args[]) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int k = 8;
        int[] out = sortedArrays(arr1, arr2);
        System.out.println(Arrays.toString(out));
        System.out.println(out[k - 1]);
    }

    public static int[] sortedArrays(int[] arr1, int[] arr2) {
        int[] sorted = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int d = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                sorted[d] = arr1[i];
                i++;
            } else if (arr1[i] > arr2[j]) {
                sorted[d] = arr2[j];
                j++;
            }
            d++;
        }
        while (i < arr1.length) {
            sorted[d] = arr1[i];
            d++;
            i++;
        }
        while (j < arr2.length) {
            sorted[d] = arr2[j];
            j++;
            d++;
        }
        return sorted;
    }
}
