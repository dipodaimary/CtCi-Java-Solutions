package Chapter5;

public class DecimalNumberToBinaryString {
    public static void main(String[] args) {
        System.out.println(toBinary2(0.72));
    }

    public static String toBinary1(long num) {
        if (num <= 0 || num >= 1) {
            return "ERROR";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        while (num > 0) {
            if (sb.length() >= 32) {
                return "ERROR";
            }
            double r = Math.multiplyExact(2, num);
            if (r >= 1) {
                sb.append(1);
                num = (long) (r - 1.0);
            } else {
                sb.append(0);
                num = (long) r;
            }
            System.out.println(num);
        }
        return sb.toString();
    }

    public static String toBinary2(double num) {
        StringBuilder sb = new StringBuilder();
        double frac = 0.5;
        sb.append(".");
        while (num > 0) {
            if (sb.length() >= 32) {
                return "ERROR";
            }
            if (num >= frac) {
                sb.append("1");
                num -= frac;
            } else {
                sb.append("0");
            }
            frac = frac / 2;
            System.out.println(sb.toString());
        }
        return sb.toString();
    }
}
