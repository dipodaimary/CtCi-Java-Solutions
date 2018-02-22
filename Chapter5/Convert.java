package Chapter5;

public class Convert {
    public static void main(String[] args) {
        System.out.println(countBitFlips(4, 7));
        System.out.println(countBitFlips2(4, 7));
    }

    public static int countBitFlips(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c >>= 1) {
            count += (c & 1);
        }
        return count;
    }

    public static int countBitFlips2(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c & (c - 1)) {
            count++;
        }
        return count;
    }
}
