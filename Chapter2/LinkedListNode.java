package Chapter2;

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

    public void setData(int d) {
        this.data = d;
    }

    public LinkedListNode getNext() {
        return this.next;
    }
}