package JavaBasics;

public class ErrorsAndExceptions {
    public static void main(String[] args) {
        String welcome = "Welcome";
        char[] chars = welcome.toCharArray();
        char lastChar = chars[chars.length - 1];
        //syntax is correct but logic is incorrect runtime error
        System.out.println(lastChar);
    }
}
