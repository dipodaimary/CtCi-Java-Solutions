package Chapter3_Stack_and_Queues;

public class MultiStack {
    public class StackInfo {
        public int start, size, capacity;

        public StackInfo(int start, int capacity) {
            this.start = start;
            this.capacity = capacity;
        }

        public boolean isWithinStackCapacity(int index) {
            //If outside of bounds of array
            if (index < 0 || index >= values.length) {
                return false;
            }
            // If index wraps around it, adjust it
            int contiguousIndex = index < start ? index + values.length : index;
            int end = start + capacity;
            return start <= contiguousIndex && contiguousIndex < end;
        }

        public int lastCapacityIndex() {
            return adjustIndex(start + capacity - 1);
        }

        public int lastElementIndex() {
            return adjustIndex(start + size - 1);
        }

        public boolean isFull() {
            return size == capacity;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    private StackInfo[] infos;
    private int[] values;

    public MultiStack(int numberOfStacks, int defaultSize) {
        // Create metadata for all the stacks
        infos = new StackInfo[numberOfStacks];
        for (int i = 0; i < numberOfStacks; i++) {
            infos[i] = new StackInfo(defaultSize * i, defaultSize);
        }
        values = new int[numberOfStacks * defaultSize];
    }

    //Push value on to the stack num
    public void push(int stackNum, int value) {
        if (allStacksAreFull()) {
            System.out.println("Stack is full");
            return;
        }
        //If this stack is full expand it
        StackInfo stack = infos[stackNum];
        if (stack.isFull()) {
            expand(stackNum);
        }
        /*
        Find the index of the top element in the array +1, and increment the stack pointer
         */
        stack.size++;
        values[stack.lastElementIndex()] = value;
    }

    //Remove value from stack
    public int pop(int stackNum) {
        StackInfo stack = infos[stackNum];
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        //Remove last element
        int value = values[stack.lastElementIndex()];
        values[stack.lastElementIndex()] = 0;
        stack.size--;
        return value;
    }

    //Get top element from the stack
    public int peek(int stackNum) {
        StackInfo stack = infos[stackNum];
        return values[stack.lastElementIndex()];
    }

    /*
    Shift items in stack over by one element. If we have available capacity, then we'll end
    up shrinking the stack by one element. If we don't have available capacity, then we will have to
    shift the stack over too
     */
    public void shift(int stackNum) {
        System.out.println("/// Shifting " + stackNum);
        StackInfo stack = infos[stackNum];
        /*
        If the stack is at full capacity, then you need to move the next
        stack over by one element. This stack can now claim the freed index
         */
        if (stack.size >= stack.capacity) {
            int nextStack = (stackNum + 1) % infos.length;
            shift(nextStack);
            stack.capacity++;
        }
        //Shift all elements in stack over by one
        int index = stack.lastCapacityIndex();
        while (stack.isWithinStackCapacity(index)) {
            values[index] = values[previousIndex(index)];
            index = previousIndex(index);
        }
        //Adjust stack data
        values[stack.start] = 0;//clear item
        stack.start = nextIndex(stack.start); //move start
        stack.capacity--;//shrink capacity

    }

    private int nextIndex(int index) {
        return adjustIndex(index + 1);
    }

    private int previousIndex(int index) {
        return adjustIndex(index - 1);
    }

    //Expand stack by shifting over other stacks
    private void expand(int stackNum) {
        shift((stackNum + 1) % infos.length);
        infos[stackNum].capacity++;
    }

    //return the number of items actually present in stack
    public int numberOfElements() {
        int size = 0;
        for (StackInfo sd : infos) {
            size += sd.size;
        }
        return size;
    }

    private boolean allStacksAreFull() {
        return numberOfElements() == values.length;
    }

    private int adjustIndex(int index) {
        int max = values.length;
        return ((index % max) + max) % max;
    }
}
