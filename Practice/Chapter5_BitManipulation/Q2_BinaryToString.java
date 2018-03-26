package BitManipulation;

public class Q2_BinaryToString {
    public static void main(String[] args) {
        System.out.println(printBinaryAlt(0.625));
    }

    public static String printBinary(double num) {
        if (num >= 1.0 | num <= 0.0) {
            return "ERROR";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while (num > 0.0) {
            if (sb.length() > 32) {
                return sb.toString();
            }
            double r = num * 2;
            System.out.println("num: " + num);
            if (r >= 1.0) {
                sb.append(1);
                num = r - 1.0;
            } else {
                sb.append(0);
                num = r;
            }
        }
        return sb.toString();
    }

    public static String printBinaryAlt(double num) {
        double frac = 0.5;
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while (num > 0.0) {
            if (sb.length() > 32) {
                return sb.toString();
            }
            if (num >= frac) {
                sb.append(1);
                num = num - frac;
            } else {
                sb.append(0);
            }
            frac /= 2;
        }
        return sb.toString();
    }
}
