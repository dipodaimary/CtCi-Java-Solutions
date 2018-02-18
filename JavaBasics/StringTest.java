package JavaBasics;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "This is a string";
        System.out.println(s1);
        String s2 = new String("This is a string");//just a matter of preference
        System.out.println(s2);
        String s3 = "Shirt size: ";
        String s4 = "M";
        String s5 = s3 + s4 + " Qty: " + 4;
        System.out.println(s5);
        char[] chars = {'H', 'e', 'l', 'l', 'o'};
        String s6 = new String(chars);
        System.out.println(s6);
        for (char c : s6.toCharArray()) {
            System.out.print(c);
        }
    }
}
