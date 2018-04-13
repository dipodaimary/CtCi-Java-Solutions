package Preparation.BankBazaar;

/*
We have N cards with each card numbered from 1 to N. All cards are randomly shuffled. We are allowed only operation moveCard(n) which moves the card with value n to the top of the pile. You are required to find out the minimum number of moveCard() operations required to sort the cards in increasing order.

Input:
The first line contains a positive integer T denoting the number of test cases. Each of the test case consists of 2 lines. The first line of each test case contains a single integer N. Next line contains space separated sequence of N integers.​

Output:
For each test case, print in new line the minimum number of operations required.​

Constraints:
1 <= T <= 1000
1 <= N <=10^6
1 <= A[i] <= N​

Example:
Input:
2
5
5 1 2 3 4
4
3 4 2 1

Output:
4
2

Explanation:

For 1st case:

5 1 2 3 4              //given sequence

4 5 1 2 3              //moveCard(4)

3 4 5 1 2              //moveCard(3)

2 3 4 5 1              //moveCard(2)

1 2 3 4 5              //moveCard(1)

Hence, minimum 4 operations are required.

For 2nd case:

3 4 2 1             //given sequence

2 3 4 1             //moveCard(2)

1 2 3 4             //moveCard(1)

Hence, minimum 2 operations are required.
 */

import java.util.Scanner;

public class SortPileOfCards {
    //Calculate the minimum number of moves to arrange array in increasing order.
    public static int minimumMoves(int[] array, int n) {
        /*
        Since we traverse array from end, expectedItem =n
         */
        //Traverse array from end
        int expectedItem = n;
        for (int i = n - 1; i >= 0; i--) {
            /*
            If current item is at its correct position, decrement the expectedItem (which
            also means decrement in minimum number of moves
             */
            if (array[i] == expectedItem) {
                expectedItem--;
            }
        }
        return expectedItem;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            for(int j=0;j<n;j++){

            }
        }
        int arr[] = {4, 3, 2, 1};
        int n = arr.length;
        System.out.println(minimumMoves(arr, n));
    }
}
