package Chapter16_Moderate;

public class Q1_NumberSwapper {
    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        System.out.println(a + ", " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + ", " + b);

    }
}
