package Chapter1;

public class Test {
    public static void main(String[] args) {
        System.out.println(isUnique("dipod"));
    }

    public static boolean isUnique(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            } else {
                checker |= (1 << val);
            }
        }
        return true;
    }
}
