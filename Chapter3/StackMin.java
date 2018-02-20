package Chapter3;

import java.util.Stack;

public class StackMin {
    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(5);
        System.out.println(stack.min());
        stack.push(6);
        stack.push(3);
        System.out.println(stack.min());
        stack.push(7);
    }

}

class StackWithMin extends Stack<NodeWithMin> {
    StackWithMin() {

    }

    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return this.peek().min;
        }
    }
}

class NodeWithMin {
    public int value;
    public int min;

    NodeWithMin(int value, int min) {
        this.value = value;
        this.min = min;
    }
}