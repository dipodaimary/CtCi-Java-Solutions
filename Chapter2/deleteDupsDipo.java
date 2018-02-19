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

class LinkedListNode {
    private int data;
    private LinkedListNode next;

    LinkedListNode() {

    }

    LinkedListNode(int d, LinkedListNode n) {
        this.data = d;
        this.next = n;
    }

    public void setNext(LinkedListNode node) {
        this.next = node;
    }

    public String printForward() {
        if (this.next != null) {
            return this.data + "->" + next.printForward();
        } else {
            return ((Integer) this.data).toString();
        }
    }

    public int getData() {
        return this.data;
    }

    public LinkedListNode getNext() {
        return this.next;
    }
}