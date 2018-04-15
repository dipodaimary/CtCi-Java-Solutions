package Preparation.BankBazaar;

public class CountNumberOfBSTPossible {
    public static void main(String[] args) {
        System.out.println(countBST(4));
    }

    public static int countBST(int n) {
        int[] list = new int[n + 1];
        list[0] = 1;
        list[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                list[i] += list[j] * list[i - j - 1];
            }
        }
        return list[n];
    }
}
