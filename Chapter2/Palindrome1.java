package Chapter2;

public class Palindrome1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        LinkedListNode first = new LinkedListNode(0, null);
        LinkedListNode head = first;
        for (int i : arr) {
            LinkedListNode second = new LinkedListNode(i, null);
            first.setNext(second);
            first = second;
        }
        first.setNext(new LinkedListNode(0, null));
        System.out.println(head.printForward());
        System.out.println(reverseAndClone(head).printForward());
        System.out.println(isEqual(head, reverseAndClone(head)));
    }

    private static LinkedListNode reverseAndClone(LinkedListNode node) {
        LinkedListNode head = null;
        while (node != null) {
            LinkedListNode n = new LinkedListNode(node.getData(), null);
            n.setNext(head);
            head = n;
            node = node.getNext();
        }
        return head;
    }

    private static boolean isEqual(LinkedListNode l1, LinkedListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.getData() != l2.getData()) {
                return false;
            }
            l1 = l1.getNext();
            l2 = l2.getNext();
        }
        return l1 == null && l2 == null;
    }
}
