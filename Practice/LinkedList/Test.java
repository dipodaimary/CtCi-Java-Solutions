public class Test {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(5);
        LinkedListNode curr = head;
        for (int i = 0; i < 8; i++) {
            curr.setNext(i % 2);
            curr = curr.getNext();
        }
        System.out.println(head.printForward());
    }
}
