public class Test {
    public static void main(String[] args) {
        System.out.println(isUnique("dipoo"));
    }

    private static boolean isUnique(String str) {
        int checker = 0;
        for (char c : str.toCharArray()) {
            int val = c - 'a';
            if ((checker & (1 << val)) != 0) {
                return false;
            } else {
                checker |= (1 << val);
            }
        }
        return true;
    }
}
