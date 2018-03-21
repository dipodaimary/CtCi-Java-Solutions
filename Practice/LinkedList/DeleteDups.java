import java.util.HashSet;

public class DeleteDups {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(5);
        LinkedListNode curr = head;
        for (int i = 0; i < 8; i++) {
            curr.setNext(2);
            curr = curr.getNext();
        }
        System.out.println(head.printForward());
        deleteDups(head);
        System.out.println(head.printForward());
    }

    public static void deleteDups(LinkedListNode head) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode prev = head;
        while (head != null) {
            if (set.contains(head.getData())) {
                prev.setNext(head.getNext());
            } else {
                set.add(head.getData());
                prev = head;
            }
            head = head.getNext();
        }
    }
}
