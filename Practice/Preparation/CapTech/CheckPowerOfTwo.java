package Preparation.BankBazaar;

public class CheckPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2));
    }

    public static boolean isPowerOfTwo(int n) {
        // Power of two elements have only one '1' bit
        return (n & (n - 1)) == 0;
    }
}
