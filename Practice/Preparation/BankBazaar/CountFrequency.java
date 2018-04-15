package Preparation.BankBazaar;

public class CountFrequency {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 2, 5};
        printFrequency(arr);
    }

    public static void printFrequency(int[] arr) {
        int n = arr.length;
        //substract 1 from each element
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] - 1;
        }
        for (int i = 0; i < n; i++) {
            arr[arr[i] % n] = arr[arr[i] % n] + n;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(i + 1 + "->" + arr[i] / n + " ");
        }
    }
}
