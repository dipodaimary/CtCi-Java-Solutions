package Chapter16Moderate;

public class SwapNumbers {
    public static void main(String[] args) {
        int a = 4;
        int b = 10;
        System.out.println(a + " " + b);
        swapNum(a, b);
    }

    private static void swapNum(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
    }
}
