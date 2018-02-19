package Chapter2;

public class KthToLast {
    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null);
        LinkedListNode head = first;
        for (int i = 1; i < 16; i++) {
            LinkedListNode second = new LinkedListNode(i, null);
            first.setNext(second);
            first = second;
        }
        System.out.println(head.printForward());
        System.out.println(kthToLast(head, 5));
    }

    public static int kthToLast(LinkedListNode head, int k) {
        LinkedListNode n1 = head;
        LinkedListNode n2 = head;
        for (int i = 0; i < k; ++i) {
            n1 = n1.getNext();
        }
        while (n1 != null) {
            n1 = n1.getNext();
            n2 = n2.getNext();
        }
        return n2.getData();
    }
}