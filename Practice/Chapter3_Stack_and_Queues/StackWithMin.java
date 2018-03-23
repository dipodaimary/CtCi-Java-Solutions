package Chapter3_Stack_and_Queues;

import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin> {
    StackWithMin() {
    }

    public void push(int d) {
        int newMin = Math.min(d, min());
        super.push(new NodeWithMin(d, newMin));
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return this.peek().min;
        }
    }

    public int getValue() {
        return this.peek().data;
    }

    public int getMinValue() {
        return this.peek().min;
    }
}

class NodeWithMin {
    int data;
    int min;

    public NodeWithMin(int v, int min) {
        data = v;
        this.min = min;
    }
}