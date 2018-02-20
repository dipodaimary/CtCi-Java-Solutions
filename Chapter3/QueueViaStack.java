package Chapter3;

import java.util.Stack;

public class QueueViaStack {
    public static void main(String[] args) {
        
    }
}

class MyQueue<T> {
    Stack<T> stackOldest, stackNewest;

    public MyQueue() {
        stackOldest = new Stack<>();
        stackNewest = new Stack<>();
    }

    public int size() {
        return stackOldest.size() + stackNewest.size();
    }

    public void add(T value) {
        stackNewest.push(value);
    }

    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    public T pop() {
        shiftStacks();
        return stackOldest.pop();
    }
}