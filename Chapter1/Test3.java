package Chapter1;

public class Test3 {

    public static void main(String[] args) {
        String pali = "Rats live on no evil star";
        //System.out.println(isPermutationOfPalindrome2(pali));
        //System.out.println(stringCompression("aaaabbcc"));
        System.out.println(isStringRotation("waterbootle", "tlewaterboo"));
    }

    private static boolean isPermutationOfPalindrome2(String pali) {
        int bitVector = createBitVector(pali);
        return bitVector == 0 || ((bitVector & (bitVector - 1)) == 0);
    }

    public static int toggle(int BitVector, int x) {
        if (x < 0) {
            return BitVector;
        }
        int mask = 1 << x;
        if ((BitVector & mask) == 0) {
            BitVector |= mask;
        } else {
            BitVector &= ~mask;
        }
        return BitVector;
    }

    public static int createBitVector(String str) {
        int bitVector = 0;
        for (char c : str.toCharArray()) {
            int val = getCharVal(c);
            bitVector = toggle(bitVector, val);
        }
        return bitVector;
    }

    private static int getCharVal(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        } else {
            return -1;
        }
    }

    private static String stringCompression(String str) {
        StringBuilder sb = new StringBuilder();
        int countConsequtive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsequtive++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                sb.append(str.charAt(i));
                sb.append(countConsequtive);
                countConsequtive = 0;
            }
        }
        return sb.toString();
    }

    private static boolean isStringRotation(String s1, String s2) {
        String s1s1 = s1 + s1;
        System.out.println(s1s1.contains(s2));
        return s1s1.contains(s2);
    }
}
