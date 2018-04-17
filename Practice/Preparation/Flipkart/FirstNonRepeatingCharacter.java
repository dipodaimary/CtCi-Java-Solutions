package Preparation.Flipkart;

import java.util.ArrayList;
import java.util.List;

public class FirstNonRepeatingCharacter {
    static final int MAX_CHAR = 256;

    public static void main(String[] args) {
        firstNonRepeatingCharacter("geeksforgeeks");
    }

    public static void firstNonRepeatingCharacter(String stream) {
        List<Character> inDLL = new ArrayList<>();
        boolean[] repeated = new boolean[MAX_CHAR];
        for (char c : stream.toCharArray()) {
            if (!repeated[c]) {
                if (!(inDLL.contains(c))) {
                    inDLL.add(c);
                } else {
                    inDLL.remove((Character) c);
                    repeated[c] = true;
                }
            }
        }
        if (inDLL.size() != 0) {
            System.out.println("First non-repeating character: " + inDLL.get(0));
        }
    }
}
