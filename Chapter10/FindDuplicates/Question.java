package Chapter10.FindDuplicates;

import java.util.Random;

public class Question {

    public static void checkDuplicates(int[] array) {
        BitSet bs = new BitSet(32000);
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int num0 = num - 1; // bitset starts at 0, numbers start at 1
            if (bs.get(num0)) {
                System.out.println(num);
            } else {
                bs.set(num0);
            }
        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        int[] array = new int[30];
        for (int i = 0; i < 30; i++) {
            array[i] = r.nextInt(30) + 1;
        }
        System.out.println();
        checkDuplicates(array);
    }

}