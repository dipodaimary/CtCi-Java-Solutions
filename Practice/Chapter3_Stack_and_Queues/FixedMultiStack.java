package Chapter3_Stack_and_Queues;

public class FixedMultiStack {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * stackCapacity];
        sizes = new int[numberOfStacks];
    }

    //Push value onto stack
    public void push(int stackNum, int value) {
        // check if we have space for the next element
        if (isFull(stackNum)) {
            System.out.println("Stack is full");
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    private boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            System.out.println("Stack is empty");
        }
        int top = values[indexOfTop(stackNum)];
        sizes[stackNum]--;
        return top;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            System.out.println("Stack is empty");
        }
        return values[indexOfTop(stackNum)];
    }

    private boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }
}
