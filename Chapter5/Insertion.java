package Chapter5;

public class Insertion {
    public static void main(String[] args) {
        System.out.println(updateBits((int) Math.pow(2, 10), 19, 2, 6));
        System.out.println((int) Math.pow(2, 10) + (int) Math.pow(2, 6) + 12);
    }

    public static int updateBits(int n, int m, int i, int j) {
        int allOnes = ~0;
        int left = allOnes << (j + 1);
        int right = ((1 << i) - 1);
        int mask = left | right;
        int n_cleared = n & mask;
        int m_shifted = m << i;
        return n_cleared | m_shifted;
    }
}
