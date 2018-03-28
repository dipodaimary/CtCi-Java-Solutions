package BitManipulation;

public class Q6_Conversion {
    public static void main(String[] args) {
        System.out.println(bitSwapRequired(4, 6));
    }

    public static int bitSwapRequired(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c >>= 1) {
            count += c & 1;
        }
        return count;
    }

    public static int bitSwapRequired2(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c & (c - 1)) {
            count++;
        }
        return count;
    }
}
