package Chapter8.MinProduct;

public class RecursiveMultiplyTrick {
    public static void main(String[] args) {
        System.out.println(multiply(2, 3));
    }

    public static int multiply(int a, int b) {
        int smaller = a > b ? b : a;
        int bigger = a > b ? a : b;
        return multiplyHelper(smaller, bigger);
    }

    private static int multiplyHelper(int smaller, int bigger) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        }
        int s = smaller >> 1;
        int halfProduct = multiply(s, bigger);
        if (s % 2 == 0) {
            return halfProduct + halfProduct;
        } else {
            return halfProduct + halfProduct + bigger;
        }
    }
}
