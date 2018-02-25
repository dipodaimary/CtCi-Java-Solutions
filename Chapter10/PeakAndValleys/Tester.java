package Chapter10.PeakAndValleys;

import java.util.Random;

public class Tester {
    public static boolean confirmValleyPeak(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            int prev = array[i - 1];
            int curr = array[i];
            int next = array[i + 1];
            if (prev <= curr && curr >= next) {
                continue;
            } else if (prev >= curr && curr <= next) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int[] originalArray = new int[100];
            Random r = new Random();
            for (int j = 0; j < 100; j++) {
                originalArray[i] = r.nextInt();
            }
            int[] arrayA = originalArray.clone();
            int[] arrayB = originalArray.clone();
            int[] arrayC = originalArray.clone();
            //System.out.println(AssortedMethods.arrayToString(array));
            QuestionA.sortValleyPeak(arrayA);
            QuestionB.sortValleyPeak(arrayB);
            QuestionC.sortValleyPeak(arrayC);
            if (!confirmValleyPeak(arrayA) || !confirmValleyPeak(arrayB) || !confirmValleyPeak(arrayC)) {
                System.out.println(confirmValleyPeak(arrayA));
                System.out.println(confirmValleyPeak(arrayB));
                System.out.println(confirmValleyPeak(arrayC));
                break;
            }
        }
    }

}