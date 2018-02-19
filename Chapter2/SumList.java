package Chapter2;

import java.util.Random;

public class SumList {
    public static void main(String[] args) {
        Random r = new Random();
        LinkedListNode first = new LinkedListNode(0, null);
        LinkedListNode l1 = first;
        for (int i = 0; i < 3; i++) {

            LinkedListNode second = new LinkedListNode(r.nextInt() % 10, null);
            first.setNext(second);
            first = second;
        }
        first = new LinkedListNode(1, null);
        LinkedListNode l2 = first;
        for (int i = 0; i < 3; i++) {
            LinkedListNode second = new LinkedListNode(r.nextInt() % 10, null);
            first.setNext(second);
            first = second;
        }
        System.out.println(l1.printForward());
        System.out.println(l2.printForward());
        LinkedListNode result = sumLists(l1, l2, 0);
        System.out.println(result.printForward());
    }

    private static LinkedListNode sumLists(LinkedListNode l1, LinkedListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        LinkedListNode result = new LinkedListNode();
        int value = carry;
        if (l1 != null) {
            value += l1.getData();
        }
        if (l2 != null) {
            value += l2.getData();
        }
        result.setData(value % 10);
        if (l1 != null || l2 != null) {
            LinkedListNode more = sumLists(l1 == null ? null : l1.getNext(), l2 == null ? null : l2.getNext(), value > 10 ? 1 : 0);
            result.setNext(more);
        }
        return result;
    }
}
