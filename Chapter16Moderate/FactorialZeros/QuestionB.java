package Chapter16Moderate.FactorialZeros;

public class QuestionB {
    public static int counFactorialZeros(int num) {
        int count = 0;
        if (num < 0) {
            return -1;
        }
        for (int i = 5; num / i > 0; i *= 5) {
            count += num / i;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(counFactorialZeros(12));
    }
}
