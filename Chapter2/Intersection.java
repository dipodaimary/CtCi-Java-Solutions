package Chapter2;

public class Intersection {
    public static void main(String[] args) {
        int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        LinkedListNode first = new LinkedListNode();
        LinkedListNode list1 = first;
        LinkedListNode list2 = new LinkedListNode(1, null);
        for (int i = 0; i < vals.length; i++) {
            LinkedListNode second = new LinkedListNode(vals[i], null);
            first.setNext(second);
            first = second;
        }
        first = list2;
        for (int i = 4; i < vals.length; i++) {
            LinkedListNode second = new LinkedListNode(vals[i], null);
            first.setNext(second);
            first = second;
        }
        System.out.println(list1.printForward());
        System.out.println(list2.printForward());
        LinkedListNode intersection = findIntersection(list1, list2);

        System.out.println(intersection.printForward());
    }

    static LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);
        if (result1.tail != result2.tail) {
            return null;
        }
        LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
        LinkedListNode longer = result1.size < result2.size ? list2 : list1;
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));
        while (shorter != longer) {
            shorter = shorter.getNext();
            longer = longer.getNext();
        }
        return longer;
    }

    static Result getTailAndSize(LinkedListNode list) {
        if (list == null) {
            return null;
        }
        int size = 1;
        LinkedListNode current = list;
        while (current.getNext() != null) {
            current = current.getNext();
            size++;
        }
        return new Result(current, size);
    }

    static LinkedListNode getKthNode(LinkedListNode head, int k) {
        LinkedListNode current = head;
        while (k > 0 && current != null) {
            current = current.getNext();
            k--;
        }
        return current;
    }
}

class Result {
    public LinkedListNode tail;
    public int size;

    public Result(LinkedListNode tail, int size) {
        this.tail = tail;
        this.size = size;
    }
}
