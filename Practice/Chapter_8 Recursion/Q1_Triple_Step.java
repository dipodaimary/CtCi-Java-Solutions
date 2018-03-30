package Recursion;

import java.util.Arrays;

public class Q1_Triple_Step {
    public static void main(String[] args) {
        System.out.println(CountWaysRecursive(20));
        int map[] = new int[20];
        Arrays.fill(map, -1);
        System.out.println(countWaysMemoized(20, map));
    }

    public static int CountWaysRecursive(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return CountWaysRecursive(n - 1) + CountWaysRecursive(n - 2) + CountWaysRecursive(n - 3);
        }
    }

    public static int countWaysMemoized(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = countWaysMemoized(n - 1, memo) + countWaysMemoized(n - 2, memo) + countWaysMemoized(n - 3, memo);
            return memo[n];
        }
    }
}
