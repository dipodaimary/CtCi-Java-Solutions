package Chapter0;

public class AllPermutations {
    public static void permutation(String str) {
        permutation(str, "");
    }

    public static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        }
        for (int i = 0; i < str.length(); i++) {
            String rem = str.substring(0, i) + str.substring(i + 1);
            permutation(rem, prefix + str.charAt(i));
        }
    }

    public static void main(String[] args) {
        permutation("dipo");
    }
}
