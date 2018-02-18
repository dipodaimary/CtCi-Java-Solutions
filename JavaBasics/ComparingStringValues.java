package JavaBasics;

public class ComparingStringValues {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        if (str1.equals(str2)) {
            System.out.println("They match");
        } else {
            System.out.println("They don't match");
        }
        if (str1.equalsIgnoreCase(str2)) {
            System.out.println("They match");
        } else {
            System.out.println("They don't match");
        }
    }
}
