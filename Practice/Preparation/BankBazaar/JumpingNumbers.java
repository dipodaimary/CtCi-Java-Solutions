package Preparation.BankBazaar;

/*
Given a positive number x, print all Jumping Numbers smaller than or equal to x. A number is called as a Jumping Number if all adjacent digits in it differ by 1. The difference between ‘9’ and ‘0’ is not considered as 1. All single digit numbers are considered as Jumping Numbers. For example 7, 8987 and 4343456 are Jumping numbers but 796 and 89098 are not.

Input:
The first line of the input contains T denoting the number of testcases. Each testcase contain a positive number 'x'.
Output:
All the jumping numbers less than 'x' are generated in increasing order of the most significant digit. See example for better understanding.


Constraints:
1 <=T<= 100
1 <=N<= 100000


Example:
Input:
2
10
50
Output:
0 1 10 2 3 4 5 6 7 8 9
0 1 10 12 2 21 23 3 32 34 4 43 45 5 6 7 8 9

Here, the most significant digits of each jumping number is following increasing order, i.e., jumping numbers starting from 0, followed by 1, then 2 and so on, themselves being in increasing order 2, 21, 23.
 */

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by poorvank on 1/16/16.
 */
public class JumpingNumbers {

    public static void main(String[] args) {
        printJump(10);
    }

    public static void printJump(int x) {
        System.out.println(0);
        for (int i = 1; i <= 9; i++) {
            bfs(x, i);
        }
    }

    public static void bfs(int x, int num) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(num);

        //do bfs starting from 1
        while (!q.isEmpty()) {
            num = q.remove();
            if (num <= x) {
                System.out.println(num + " ");
                int last_digit = num % 10;
                //If last digit is 0 add next digit only
                if (last_digit == 0)
                    q.add(num * 10 + last_digit + 1);
                //If last digit is 9 add previous digit only
                if (last_digit == 9)
                    q.add(num * 10 + last_digit - 1);
                //If last digit is between 0 and 9 add both previous and next digits
                if (last_digit > 0 & last_digit < 9) {
                    q.add(num * 10 + last_digit + 1);
                    q.add(num * 10 + last_digit - 1);
                }
            }

        }
    }

}