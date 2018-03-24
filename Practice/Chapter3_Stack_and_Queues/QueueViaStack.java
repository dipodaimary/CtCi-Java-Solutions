package Chapter3_Stack_and_Queues;

import java.util.Stack;

public class QueueViaStack {

}

class MyQueue<T> {
    Stack<T> stackOldest, stackNewest;

    public MyQueue() {
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
    }

    public int size() {
        return stackOldest.size() + stackNewest.size();
    }

    public void add(T n) {
        stackNewest.push(n);
    }

    public T peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    public T pop() {
        shiftStacks();
        return stackOldest.pop();
    }

    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }
}