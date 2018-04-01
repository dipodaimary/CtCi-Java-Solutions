package SortingAndSearching;

import java.util.Arrays;

public class Q1_SortedMerge {
    public static void main(String[] args) {
        int[] A = {2, 4, 6, 0, 0, 0};
        System.out.println(Arrays.toString(A));
        int[] B = {1, 3, 5};
        System.out.println(Arrays.toString(B));
        merge(A, B, 3, 3);
        System.out.println(Arrays.toString(A));
    }

    public static void merge(int[] a, int[] b, int lastA, int lastB) {
        int indexMerged = lastB + lastA - 1; /* Index of last location of merged array */
        int indexA = lastA - 1; /* Index of last element in array b */
        int indexB = lastB - 1; /* Index of last element in array a */

        /* Merge a and b, starting from the last element in each */
        while (indexB >= 0) {
            if (indexA >= 0 && a[indexA] > b[indexB]) { /* end of a is bigger than end of b */
                a[indexMerged] = a[indexA]; // copy element
                indexA--;
            } else {
                a[indexMerged] = b[indexB]; // copy element
                indexB--;
            }
            indexMerged--; // move indices
        }
    }
}
