package Chapter16Moderate.ContiguousSumSequence;

public class Question {
    public static void main(String[] args) {
        int[] arr = {-1, 2, -4, 3, 6, -8, -2};
        System.out.println(maxSum(arr));
    }

    public static int maxSum(int[] arr) {
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > maxSum) {
                maxSum = sum;
            } else if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
