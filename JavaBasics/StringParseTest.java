package JavaBasics;

public class StringParseTest {
    public static void main(String[] args) {
        String str1 = "Welcome to California";
        int position = str1.indexOf("California");
        System.out.println(position);
        System.out.println(str1.substring(11));
        System.out.println(str1.trim().length());
    }
}
