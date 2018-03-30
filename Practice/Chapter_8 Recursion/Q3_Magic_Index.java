package Recursion;

public class Q3_Magic_Index {
    public static void main(String[] args) {
        int arr[] = {22, 4, 2, 3, 44, 45, 89};
        System.out.println(findMagicIndexFast(arr));
    }

    public static int findMagicIndex(int[] arr) {
        return findMagicIndex(arr, 0, arr.length - 1);
    }

    private static int findMagicIndex(int[] arr, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == mid) {
            return mid;
        } else if (arr[mid] < mid) {
            return findMagicIndex(arr, mid + 1, end);
        } else {
            return findMagicIndex(arr, start, mid - 1);
        }
    }

    public static int findMagicIndexFast(int[] arr) {
        return findMagicIndexFast(arr, 0, arr.length - 1);
    }

    private static int findMagicIndexFast(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midValue = arr[midIndex];
        if (midIndex == midValue) {
            return midIndex;
        }
        //Search Left
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = findMagicIndexFast(arr, start, leftIndex);
        if (left >= 0) {
            return left;
        }
        //Search right
        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = findMagicIndexFast(arr, rightIndex, end);
        return right;
    }
}
