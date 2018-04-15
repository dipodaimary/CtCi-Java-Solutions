package Preparation.Flipkart;

import java.util.Deque;
import java.util.LinkedList;

public class PrintBracketNumber {
    public static void main(String[] args) {
        printBracketNumber("(a+(b*c))+(d/e)​");
    }

    public static void printBracketNumber(String s) {
        int leftCount = 0;
        Deque<Integer> rightBracketNumber = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c.equals('(')) {
                leftCount++;
                rightBracketNumber.push(leftCount);
                System.out.print(leftCount + " ");
            } else if (c.equals(')')) {
                System.out.print(rightBracketNumber.getFirst() + " ");
                rightBracketNumber.removeFirst();
            }
        }
    }
}
