package Chapter3;

import java.util.Random;
import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Random r = new Random();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 100; i++) {
            stack.push(r.nextInt() % 100);
        }
        System.out.println(stack);
        sortStack(stack);
        System.out.println(stack);
    }

    public static void sortStack(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();
        while (!s.isEmpty()) {
            int temp = s.pop();
            while (!r.isEmpty() && temp < r.peek()) {
                s.push(r.pop());
            }
            r.push(temp);
        }
        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }
}
