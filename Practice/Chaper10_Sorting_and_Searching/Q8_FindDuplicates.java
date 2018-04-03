package SortingAndSearching;

import java.util.Random;

public class Q8_FindDuplicates {
    public static void main(String[] args) {
        int[] array = new int[30];
        Random r = new Random();
        for (int i = 0; i < 30; i++) {
            array[i] = r.nextInt();
        }
        checkDuplicates(array);
    }

    public static void checkDuplicates(int[] array) {
        BitSet bs = new BitSet(32000);
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int num0 = num - 1;//bitset starts with 0 but number starts with 1
            if (bs.get(num0)) {
                System.out.println(num);
            } else {
                bs.set(num0);
            }
        }
    }
}

class BitSet {
    int[] bitset;

    public BitSet(int size) {
        bitset = new int[(size >> 5) + 1]; // divide by 32
    }

    boolean get(int pos) {
        int wordNumber = (pos >> 5); // divide by 32
        int bitNumber = (pos & 0x1F); // mod 32
        return (bitset[wordNumber] & (1 << bitNumber)) != 0;
    }

    void set(int pos) {
        int wordNumber = (pos >> 5); // divide by 32
        int bitNumber = (pos & 0x1F); // mod 32
        bitset[wordNumber] |= 1 << bitNumber;
    }
}