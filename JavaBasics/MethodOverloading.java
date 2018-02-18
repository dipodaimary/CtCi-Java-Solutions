package JavaBasics;

import java.util.Scanner;

public class MethodOverloading {
    public static void main(String[] args) {
        String s1 = getInput("Enter first value: ");
        String s2 = getInput("Enter second value: ");
        String s3 = getInput("Enter third value: ");
        System.out.println(addValues(s1, s2));
        System.out.println(addValues(s1, s2, s3));
    }

    static String getInput(String prompt) {
        System.out.println(prompt);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    static double addValues(String s1, String s2) {
        double d1 = Double.parseDouble(s1);
        double d2 = Double.parseDouble(s2);
        double result = d1 + d2;
        return result;
    }

    static double addValues(String s1, String s2, String s3) {
        double d1 = Double.parseDouble(s1);
        double d2 = Double.parseDouble(s2);
        double d3 = Double.parseDouble(s3);

        double result = d1 + d2 + d3;
        return result;
    }
}
