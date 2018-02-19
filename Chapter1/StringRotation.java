package Chapter1;

public class StringRotation {
    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }

    public static boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s2;
            return s1s1.contains(s2);
        }
        return false;
    }
}
