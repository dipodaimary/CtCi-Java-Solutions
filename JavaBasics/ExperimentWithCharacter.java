package JavaBasics;

public class ExperimentWithCharacter {
    public static void main(String[] args) {
        System.out.println('\u0024');
        char a = 'a';
        char a2 = 'b';
        char a3 = 'c';
        System.out.print(Character.toUpperCase(a));
        System.out.print(Character.toUpperCase(a2));
        System.out.println(Character.toUpperCase(a3));
    }
}
