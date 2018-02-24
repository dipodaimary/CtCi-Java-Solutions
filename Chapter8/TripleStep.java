package Chapter8;

import java.util.Arrays;

public class TripleStep {
    public static void main(String[] args) {
        System.out.println(tripleSetRecursive(6));
        System.out.println(tripleSetMemoized(6));
    }

    public static int tripleSetRecursive(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return tripleSetRecursive(n - 1) + tripleSetRecursive(n - 2) + tripleSetRecursive(n - 3);
        }
    }

    public static int tripleSetMemoized(int n) {
        int memo[] = new int[n + 1];
        Arrays.fill(memo, -1);
        int ans = tripleSetMemoized(n, memo);
        return ans;
    }

    private static int tripleSetMemoized(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = tripleSetMemoized(n - 1, memo) + tripleSetMemoized(n - 2, memo) + tripleSetMemoized(n - 3, memo);
            return memo[n];
        }
    }
}
