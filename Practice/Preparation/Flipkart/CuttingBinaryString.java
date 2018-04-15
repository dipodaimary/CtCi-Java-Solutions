package Preparation.Flipkart;

public class CuttingBinaryString {
    public static void main(String[] args) {
        System.out.println(numOfWays("101101101"));
    }

    public static int numOfWays(String s) {
        long[] f = new long[s.length() + 1];
        f[0] = 0;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= 1; ++j) {
                if (s.charAt(j - 1) == '0') {
                    continue;
                }
                int num = Integer.parseInt(s.substring(j - 1, i), 2);
                if (isPower(num)) {
                    f[i] = Math.min(f[i], f[j - 1] + 1);
                }
            }
        }
        return f[s.length()] == Integer.MAX_VALUE ? -1 : (int) f[s.length()];
    }

    private static boolean isPower(int num) {
        if (num == 0) {
            return false;
        }
        int n = (int) (Math.log(num) / Math.log(5));
        return Math.pow(5, n) == num;
    }
}
