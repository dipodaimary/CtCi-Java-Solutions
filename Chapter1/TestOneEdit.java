package Chapter1;

public class TestOneEdit {
    public static boolean oneEditDistance(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }
        String s1 = str1.length() > str2.length() ? str2 : str1;
        String s2 = str1.length() > str2.length() ? str1 : str2;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;

        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
                if (s1.length() == s2.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "palee";
        String b = "pale";
        boolean isOneEdit1 = oneEditDistance(a, b);
        System.out.println(a + ", " + b + ": " + isOneEdit1);

        String c = "pale";
        String d = "pkle";
        boolean isOneEdit2 = oneEditDistance(c, d);
        System.out.println(c + ", " + d + ": " + isOneEdit2);
    }
}
