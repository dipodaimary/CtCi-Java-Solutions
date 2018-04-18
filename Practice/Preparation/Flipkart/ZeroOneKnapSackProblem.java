package Preparation.Flipkart;

public class ZeroOneKnapSackProblem {
    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }

    public static int knapSack(int w, int[] wt, int[] val, int n) {
        //Base case
        if (n == 0 || w == 0) {
            return 0;
        }
        //If weight of nth item is more than Knapsack capacity W, then this item
        //can not be included in the optimal solution
        if (wt[n - 1] > w) {
            return knapSack(w, wt, val, n - 1);
            //Return the maximum of two cases:
            //(1) nth item included
            //(2) not included
        } else {
            return Math.max(val[n - 1] + knapSack(w - wt[n - 1],
                    wt, val, n - 1), knapSack(w, wt, val, n - 1));
        }
    }
}
