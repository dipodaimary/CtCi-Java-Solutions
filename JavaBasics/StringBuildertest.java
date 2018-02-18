package JavaBasics;

import java.util.Scanner;

public class StringBuildertest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello ").append("world");
        System.out.println(sb.toString());
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value");
        String input = scanner.nextLine();
        System.out.println(input);
        sb.delete(0, sb.length());
        for (int i = 0; i < sb.length(); i++) {
            input = scanner.nextLine();
            sb.append(input + '\n');

        }
    }
}
