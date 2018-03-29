package Recursion;

public class getPath {
    public static void main(String[] args) {
        System.out.println(CountWaysRecursive(20));
    }

    public static int CountWaysRecursive(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return CountWaysRecursive(n - 1) + CountWaysRecursive(n - 2) + CountWaysRecursive(n - 3);
        }
    }
}
