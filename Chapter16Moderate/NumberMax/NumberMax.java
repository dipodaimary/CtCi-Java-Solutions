package Chapter16Moderate.NumberMax;

public class NumberMax {

    public static int flip(int bit) {
        return 1 ^ bit;
    }

    public static int sign(int a) {
        return flip((a >> 31) & 0x1);
    }

    public static int getMaxNaive(int a, int b) {
        int k = sign(a - b);
        int q = flip(k);
        return a * k + b * q;
    }

    public static void main(String[] args) {
        System.out.println(getMaxNaive(4, 5));
    }
}
