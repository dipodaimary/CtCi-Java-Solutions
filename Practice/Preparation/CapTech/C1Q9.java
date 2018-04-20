package Preparation.CapTech;

public class C1Q9 {
    public static void main(String[] args) {
        isRotation("waterbootle", "erbootlewa");
        System.out.println(isRotation("waterbootle", "erbootlewat"));
    }

    public static boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return s1s1.contains(s2);
        }
        return false;
    }
}
