package Chapter16_Moderate;

public class Q5_FactorialZeros {
    public static void main(String[] args) {
        for (int i = 1; i < 12; i++) {
            System.out.println(i + "! (or " + factorial(i) + ") has " + countFactZeros(i) + " zeros");
        }
    }

    public static int factorsOf5(int i) {
        int count = 0;
        while (i % 5 == 0) {
            count++;
            i /= 5;
        }
        return count;
    }

    public static int countFactZeros(int num) {
        int count = 0;
        for (int i = 2; i <= num; i++) {
            count += factorsOf5(i);
        }
        return count;
    }

    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        } else if (num > 1) {
            return num * factorial(num - 1);
        } else {
            return -1; // Error
        }
    }
}

class QuestionB {
    public static int countFactZeros(int num) {
        int count = 0;
        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers");
            return 0;
        }
        for (int i = 5; num / i > 0; i *= 5) {
            count += num / i;
        }
        return count;
    }

    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        } else if (num > 1) {
            return num * factorial(num - 1);
        } else {
            return -1; // Error
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 12; i++) {
            System.out.println(i + "! (or " + factorial(i) + ") has " + countFactZeros(i) + " zeros");
        }
    }
}