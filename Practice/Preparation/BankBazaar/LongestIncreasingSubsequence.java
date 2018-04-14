package Preparation.BankBazaar;

/*
Given a sequence, find the length of the longest increasing subsequence from a given sequence .
The longest increasing subsequence means to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest
to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.

Note: Duplicate numbers are not counted as increasing subsequence.

For example:
 length of LIS for
{ 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.



Input:

The first line contains an integer T, depicting total number of test cases.
Then following T lines contains an integer N depicting the size of array and next line followed by the value of array.


Output:

Print the Max length of the subsequence in a separate line.


Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 1000
0 ≤ A[i] ≤ 300

Example:
 */

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] result = lis(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] lis(int[] X) {
        int n = X.length - 1;
        int[] M = new int[n + 1];
        int[] P = new int[n + 1];
        int L = 0;
        for (int i = 1; i < n + 1; i++) {
            int j = 0;
            /*
            Linear search is applied here. Binary search can also be applied.
            Binary seach for largest positive j<=L such that X[M[j]]<X[i]
            (or set j=0 if no such value exists
             */
            for (int pos = L; pos >= 1; pos--) {
                if (X[M[pos]] < X[i]) {
                    j = pos;
                    break;
                }
            }
            P[i] = M[j];
            if (j == L || (X[i] < X[M[j + 1]])) {
                M[j + 1] = i;
                L = Math.max(L, j + 1);
            }
        }
        //Backtrack
        int[] result = new int[L];
        int pos = M[L];
        for (int i = L - 1; i >= 0; i--) {
            result[i] = X[pos];
            pos = P[pos];
        }
        return result;
    }
}
