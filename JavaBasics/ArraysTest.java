package JavaBasics;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        int[] sized = new int[10];
        for (int i = 0; i < 10; i++) {
            sized[i] = i * 100;
        }
        Arrays.sort(sized);
        int[] copied = new int[5];
        System.arraycopy(sized, 5, copied, 0, 5);
        for (int i = 0; i < 5; i++) {
            System.out.print(copied[i]);
        }
    }
}
