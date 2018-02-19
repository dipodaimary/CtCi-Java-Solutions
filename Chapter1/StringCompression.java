package Chapter1;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(CompressString("aaaabbcc"));
    }

    private static String CompressString(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsqutive = 0;
        for (int i = 0; i < str.length(); ++i) {
            countConsqutive++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsqutive);
                countConsqutive = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }
}
