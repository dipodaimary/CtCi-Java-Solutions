package Preparation.BankBazaar;

import java.util.Arrays;
import java.util.Scanner;

/*
Given an array, find inversion count of array.

Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,N is the size of array.
The second line of each test case contains N input C[i].

Output:

Print the inversion count of array.

Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 100
1 ≤ C ≤ 500

Example:

Input:
1
5
2 4 1 3 5

Output:
3
 */
public class InversionOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t, n;
        int[] arr;
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            arr = new int[n];
            for (int j = 0; j < n; j++)
                arr[j] = sc.nextInt();
            System.out.println(mergeSort(arr, 0, n - 1));
        }
    }

    public static int merge(int[] arr, int[] LArr, int[] RArr, int m, int n) {
        int i = 0, j = 0, k = 0;
        int count = 0;
        while (i < m && j < n) {
            if (LArr[i] <= RArr[j]) {
                arr[k++] = LArr[i++];
            } else {
                arr[k++] = RArr[j++];
                count = count + m - i;
            }
        }
        //duplicates and equal elements
        while (i < m) {
            arr[k++] = LArr[i++];
        }
        while (j < n) {
            arr[k++] = RArr[j++];
        }
        return count;
    }

    public static int mergeSort(int[] arr, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 0;
        }
        if (start == end - 1) {
            if (arr[start] <= arr[end]) {
                return 0;
            } else {
                //Swap elements by bitwise operation
                arr[start] = arr[start] ^ arr[end];
                arr[end] = arr[start] ^ arr[end];
                arr[start] = arr[start] ^ arr[end];
            }
            return 1;
        }
        int mid = (start + end) / 2;
        int[] LArr = new int[mid + 1];
        int[] RArr = new int[end - mid];

        for (int i = start; i <= mid; i++) {
            LArr[i] = arr[i];
        }
        for (int i = mid + 1; i <= end; i++) {
            RArr[i - (mid + 1)] = arr[i];
        }
        int count = 0;
        count += mergeSort(LArr, 0, mid);
        count += mergeSort(RArr, 0, end - mid - 1);
        count += merge(arr, LArr, RArr, mid + 1, end - mid);
        System.out.println(Arrays.toString(arr));
        return count;
    }
}
