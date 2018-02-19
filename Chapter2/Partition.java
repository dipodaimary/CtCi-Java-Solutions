package Chapter2;

import java.util.Random;

public class Partition {
    public static void main(String[] args) {
        Random r = new Random();
        LinkedListNode first = new LinkedListNode(0, null);
        LinkedListNode head = first;
        for (int i = 0; i < 16; i++) {
            LinkedListNode second = new LinkedListNode(r.nextInt() % 20, null);
            first.setNext(second);
            first = second;
        }
        System.out.println(head.printForward());
        partition(head, 6);
        System.out.println(head.printForward());
    }

    public static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;
        while (node != null) {
            LinkedListNode next = node.getNext();
            if (node.getData() < x) {
                node.setNext(head);
                head = node;
            } else {
                tail.setNext(node);
                tail = node;
            }
            node = next;
        }
        tail.setNext(null);
        return head;
    }
}
