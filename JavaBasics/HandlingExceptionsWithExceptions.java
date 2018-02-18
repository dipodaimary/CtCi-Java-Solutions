package JavaBasics;

public class HandlingExceptionsWithExceptions {
    public static void main(String[] args) {
        String welcome = "welcome!";
        char[] chars = welcome.toCharArray();

        try {
            char lastChar = chars[chars.length - 1];
            System.out.println(lastChar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
