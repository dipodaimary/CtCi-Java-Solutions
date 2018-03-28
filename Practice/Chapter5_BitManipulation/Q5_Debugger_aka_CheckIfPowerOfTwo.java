package BitManipulation;

public class Q5_Debugger_aka_CheckIfPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(powerOfTwo(5));
    }

    private static boolean powerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }
}
