import java.util.Random;

public class SumList {
    public static void main(String[] args) {
        LinkedListNode head1 = new LinkedListNode(4);
        LinkedListNode curr = new LinkedListNode();
        Random r = new Random();
        curr = head1;
        for (int i = 1; i < 9; i++) {
            curr.setNext(r.nextInt(9));
            curr = curr.getNext();
        }
        LinkedListNode head2 = new LinkedListNode(4);
        curr = head2;
        for (int i = 1; i < 9; i++) {
            curr.setNext(r.nextInt(9));
            curr = curr.getNext();
        }
        System.out.println(head1.printForward());
        System.out.println(head2.printForward());
        LinkedListNode result = sumLists(head1, head2, 0);
        System.out.println(result.printForward());
    }

    public static LinkedListNode sumLists(LinkedListNode n1, LinkedListNode n2, int carry) {
        if (n1 == null && n2 == null && carry == 0) {
            return null;
        }
        LinkedListNode result = new LinkedListNode();
        int value = carry;
        if (n1 != null) {
            value += result.getData() + n1.getData();
        }
        if (n2 != null) {
            value += result.getData() + n2.getData();
        }
        result.setData(value % 10);
        if (n1 != null || n2 != null) {
            LinkedListNode more = sumLists(n1 == null ? null : n1.getNext(), n2 == null ? null : n2.getNext(), value > 10 ? 1 : 0);
            result.setNext(more);
        }
        return result;
    }
}
