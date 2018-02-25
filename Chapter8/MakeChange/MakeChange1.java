package Chapter8.MakeChange;

public class MakeChange1 {
    public static void main(String[] args) {
        System.out.println(makeChange(100));
    }

    public static int makeChange(int amount, int[] denoms, int index) {
        if (index >= denoms.length - 1) {
            return 1;//last denom
        }
        int denomAmount = denoms[index];
        int ways = 0;
        for (int i = 0; i * denomAmount <= amount; i++) {
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange(amountRemaining, denoms, index + 1);
        }
        return ways;
    }

    public static int makeChange(int n) {
        int[] denoms = {1, 5, 10, 25};
        return makeChange(n, denoms, 0);
    }
}
