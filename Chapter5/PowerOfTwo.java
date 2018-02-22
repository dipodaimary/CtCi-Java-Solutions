package Chapter5;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));
    }

    private static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }
}
