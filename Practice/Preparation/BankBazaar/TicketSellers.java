package Preparation.BankBazaar;

import java.util.Arrays;
import java.util.Scanner;

public class TicketSellers {
    static final int no = 1 << 20;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
            }
            int[] data = new int[no];
            int m = -1;
            for (int j = 0; j < n; j++) {
                data[a[j]]++;
                if (m < a[j]) {
                    m = a[j];
                }
            }
            System.out.println(maxAmountSold(a, n, k, data, m));
        }
    }

    public static int maxAmountSold(int[] a, int n, int x, int[] data, int m) {
        int ans = 0;
        for (int i = 0; i < x; i++) {
            if (data[m] > 1) {
                ans += m;
                data[m - 1]++;
                data[m]--;
            } else if (data[m] != 0) {
                ans += m;
                data[--m]++;
            }
        }
        return ans;
    }
}
