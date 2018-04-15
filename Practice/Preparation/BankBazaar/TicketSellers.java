package Preparation.BankBazaar;


import java.util.Scanner;

public class TicketSellers {
    static final int max = 1 << 20; //Maximum number of tickets a salesman can carry

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int iter = 0; iter < t; iter++) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            int[] buffer = new int[max];
            int m = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                buffer[array[i]]++;
                if (m < array[i]) {
                    m = array[i];
                }
            }

            System.out.println(getMaxSale(array, k, buffer, m));
        }
    }

    public static int getMaxSale(int[] array, int ticketsToSell, int[] buffer, int m) {
        int ans = 0;
        for (int i = 0; i < ticketsToSell; i++) {
            if (buffer[m] > 1) {
                ans += m;
                buffer[m]--;
            } else if (buffer[m] != 0) {
                ans += m;
                m = m - 1;  //decrease price available
                buffer[m]++;
            }
        }
        return ans;
    }
}
