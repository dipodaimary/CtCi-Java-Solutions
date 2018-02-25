package Chapter8.MinProduct;

import java.util.Arrays;

public class RecursiveMultiplyMemo {
    public static void main(String[] args) {
        System.out.println(multiply(2, 3));
    }

    public static int multiply(int a, int b) {
        int smaller = a > b ? b : a;
        int bigger = a > b ? a : b;
        int memo[] = new int[smaller + 1];
        Arrays.fill(memo, -1);
        return multiplyHelper(smaller, bigger, memo);
    }

    private static int multiplyHelper(int smaller, int bigger, int[] memo) {
        if (smaller == 0) {
            return 0;
        }
        if (smaller == 1) {
            return bigger;
        }
        if (memo[smaller] > 0) {
            return memo[smaller];
        }
        int s = smaller >> 1;
        int side1 = multiplyHelper(s, bigger, memo);
        int side2 = side1;
        if (s % 2 == 1) {
            side2 = multiplyHelper(smaller - s, bigger, memo);
        }
        memo[smaller] = side1 + side2;
        return memo[smaller];
    }
}
