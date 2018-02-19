public class Test {
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
}