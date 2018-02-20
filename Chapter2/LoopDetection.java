package Chapter2;

public class LoopDetection {
    public static void main(String[] args) {
        LinkedListNode[] list = new LinkedListNode[100];
        list[0] = new LinkedListNode(0, null);
        LinkedListNode head = list[0];
        for (int i = 1; i < 100; i++) {
            list[i] = new LinkedListNode(i, null);
            list[i - 1].setNext(list[i]);
        }
        System.out.println(head.printForward());
        //create cycle
        list[99].setNext(list[55]);
        System.out.println(findLoop(head).getData());
    }

    private static LinkedListNode findLoop(LinkedListNode list) {
        LinkedListNode slow = list;
        LinkedListNode fast = list;
        while (slow != null && fast != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || slow == null) {
            return null;
        }
        slow = list;
        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return fast;
    }
}
