package JavaBasics;

public class ArgumentTest {
    public static void main(String[] args) {
        System.out.println("Hello world");
        try {
            System.out.println("You typed: " + args[0] + " as argument.");
        } catch (Exception e) {
            System.out.println("You did not put any argument.");
        }
    }
}
