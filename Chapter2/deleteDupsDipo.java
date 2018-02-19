package Chapter2;

public class deleteDupsDipo {
    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null);
            first.setNext(second);
            first = second;
        }
        System.out.println(head.printForward());
        deleteDups(head);
        System.out.println(head.printForward());
    }

    private static void deleteDups(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null) {
            LinkedListNode runner = current;
            while (runner.getNext() != null) {
                if (runner.getNext().getData() == current.getData()) {
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }
    }
}