package Chapter8;

public class MagicIndex {
    public static void main(String[] args) {
        int[] arr = {-3, -2, -1, 3, 4, 5,};
        System.out.println(magicIndex(arr, 0, arr.length));
    }

    public static int magicIndex(int[] arr, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == mid) {
            return mid;
        }
        if (arr[mid] < mid) {
            return magicIndex(arr, mid + 1, end);
        } else {
            return magicIndex(arr, start, mid - 1);
        }
    }
}
