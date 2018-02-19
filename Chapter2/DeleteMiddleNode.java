package Chapter2;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null);
        LinkedListNode head = first;
        for (int i = 1; i < 15; i++) {
            LinkedListNode second = new LinkedListNode(i, null);
            first.setNext(second);
            first = second;
        }
        System.out.println(head.printForward());
        deleteMiddleNode(head);
        System.out.println(head.printForward());
    }

    public static boolean deleteMiddleNode(LinkedListNode node) {
        if (node == null || node.getNext() == null) {
            return false;
        }
        LinkedListNode next = node.getNext().getNext();
        node.setData(next.getData());
        node.setNext(next.getNext());
        return true;
    }
}
