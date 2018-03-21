public class LinkedListNode {
    private int data;
    private LinkedListNode next;
    private LinkedListNode prev;
    private LinkedListNode last;

    public LinkedListNode(int data, LinkedListNode n, LinkedListNode p) {
        this.data = data;
        next = n;
        prev = p;
    }

    public LinkedListNode(int data) {
        this.data = data;
    }

    public LinkedListNode() {

    }

    public String printForward() {
        if (next != null) {
            return this.data + " -> " + next.printForward();
        } else {
            return ((Integer) data).toString();
        }
    }

    public void setNext(int d) {
        next = new LinkedListNode(d);
    }

    public LinkedListNode getNext() {
        return next;
    }

    public int getData() {
        return this.data;
    }

    public void setNext(LinkedListNode n) {
        this.next = n;
    }
}
