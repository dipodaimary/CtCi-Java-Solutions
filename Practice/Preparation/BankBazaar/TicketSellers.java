package Preparation.BankBazaar;

import java.util.Scanner;

public class TicketSellers {
    static final int no = 1 << 20;//Maximum number of tickets a salesman carry

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();   //Number of elements in the input array
            int k = in.nextInt();   //Target number of Tickets to sell
            int[] array = new int[n];   //array to store number of tickets
            for (int j = 0; j < n; j++) {
                array[j] = in.nextInt();
            }
            int[] buffer = new int[no]; //buffer to store ticket counts
            int m = Integer.MIN_VALUE;  //Will store the maximum number of tickets from ticket array
            for (int j = 0; j < n; j++) {
                buffer[array[j]]++;
                if (m < array[j]) {
                    m = array[j];
                }
            }
            System.out.println(maxAmountSold(array, n, k, buffer, m));
        }
    }

    public static int maxAmountSold(int[] array, int n, int ticketsToSell, int[] buffer, int m) {
        int ans = 0;
        for (int i = 0; i < ticketsToSell; i++) {
            if (buffer[m] > 1) {
                ans += m;
                buffer[m - 1]++; //since price of the ticket will decrease
                buffer[m]--;
            } else if (buffer[m] != 0) {
                ans += m;
                m = m - 1;//Decrement m ie maximum value by 1
                buffer[m]++;
            }
        }
        return ans;
    }
}
