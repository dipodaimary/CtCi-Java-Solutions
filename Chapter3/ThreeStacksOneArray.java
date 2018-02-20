package Chapter3;

public class ThreeStacksOneArray {
    public static void main(String[] args) {
        FixedMultiStack stacks = new FixedMultiStack(4);
        stacks.push(1, 3);
        stacks.printStack();
    }

    private static class FixedMultiStack {
        private int numOfStacks = 3;
        private int stackCapacity;
        private int[] values;
        private int[] sizes;

        public FixedMultiStack(int stackSize) {
            stackCapacity = stackSize;
            values = new int[stackSize * numOfStacks];
            sizes = new int[numOfStacks];
        }

        //push value onto the stack
        public void push(int stackNum, int value) {
            if (isFull(stackNum)) {
                System.out.println("Stack full");
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
            int topIndex = indexOfTop(stackNum);
            int value = values[topIndex];
            sizes[stackNum]--;
            return value;
        }

        private boolean isEmpty(int stackNum) {
            return sizes[stackNum] == 0;
        }

        //return top element
        private int peek(int stackNum) {
            if (isEmpty(stackNum)) {
                System.out.println("Stack is empty");
            }
            return values[indexOfTop(stackNum)];
        }

        private void printStack() {
            for (int i = 0; i < numOfStacks * stackCapacity - 1; i++) {
                System.out.println(values[i]);
            }
        }
    }

}
