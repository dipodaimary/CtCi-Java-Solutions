package Chapter3_Stack_and_Queues;

public class Test {
    public static void main(String[] args) {
        FixedMultiStack multiStack = new FixedMultiStack(4);
        multiStack.push(0, 1);
        multiStack.push(1, 2);
        multiStack.push(1, 3);
        multiStack.push(2, 4);
        multiStack.push(0, 11);
        multiStack.push(0, 12);
        multiStack.push(0, 13);
        multiStack.push(0, 14);
        System.out.println(multiStack.pop(0));
        System.out.println(multiStack.pop(0));
        multiStack.printValues();
    }
}