package Chapter6;

import java.util.Random;

public class GenderRation {
    public static void main(String[] args) {
        int girl = 0;
        int boy = 0;
        for (int i = 0; i < 100000; i++) {
            int[] childern = family();
            boy += childern[0];
            girl += childern[1];
        }
        double ratio = ((double) girl / (double) boy);
        System.out.println(boy + " - " + girl + " " + ratio);
    }

    public static int[] family() {
        int boy = 0;
        int girl = 0;
        Random r = new Random();
        while (true) {
            if (r.nextBoolean()) {
                girl += 1;
                break;
            } else {
                boy++;
            }
        }
        int gender[] = {boy, girl};
        return gender;
    }
}
