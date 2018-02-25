package Chapter8;

public class RecursivelyMultiply {
    public static void main(String[] args) {
        System.out.println(multiply(10, 3));
    }

    public static int multiply(int a, int b) {
        int smaller = a > b ? b : a;
        int bigger = a > b ? a : b;
        int ans = multiplyHelper(smaller, bigger);
        return ans;
    }

    private static int multiplyHelper(int smaller, int bigger) {
        if (smaller == 0) {
            return 0;
        }
        if (smaller == 1) {
            return bigger;
        }
        int s = smaller >> 1;
        int side1 = multiply(s, bigger);
        int side2 = side1;
        if (s % 2 == 1) {
            side2 = multiply(smaller - s, bigger);
        }
        return side1 + side2;
    }
}
