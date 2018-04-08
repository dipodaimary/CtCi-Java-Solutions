package Chapter16_Moderate;

public class Q7_NumberMax {
    public static void main(String[] args) {
        System.out.println(getMax(5, 6));
    }

    public static int flip(int bit) {
        return 1 ^ bit;
    }

    public static int sign(int a) {
        return flip((a >> 31) & 0x1);
    }

    public static int getMax(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        /*
        Goal: define a value k which is 1 if a>b and 0 if a<b
        if a==b then it does not matter what value is k
         */
        //If a and b have different sign then k =sign(a)
        int use_sign_a = sa ^ sb;
        //If a and b have same sign then k = sign(a-b)
        int use_sign_c = flip(sa ^ sb);
        int k = use_sign_a * sa + use_sign_c * sc;
        int q = flip(k);
        return a * k + q * b;

    }
}
