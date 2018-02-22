package Chapter5;

public class SwapOddEvenBits {
    public static void main(String[] args) {
        System.out.println(swapbits(7));
    }

    public static int swapbits(int x) {
        return ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1);
    }
}
