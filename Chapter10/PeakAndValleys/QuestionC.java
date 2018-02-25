package Chapter10.PeakAndValleys;


public class QuestionC {
    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void sortValleyPeak(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            if (array[i - 1] < array[i]) {
                swap(array, i - 1, i);
            }
            if (i + 1 < array.length && array[i + 1] < array[i]) {
                swap(array, i + 1, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 1, 2, 3};
        sortValleyPeak(array);
        System.out.println(Tester.confirmValleyPeak(array));
    }

}