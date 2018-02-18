package JavaBasics;

public class CustomExeption {
    public static void main(String[] args) {
        String welcome = "Welcome!";
        char[] chars = welcome.toCharArray();
        try {
            if (chars.length < 10) {
                throw (new Exception("My Custom Message"));
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
