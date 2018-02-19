package Chapter2;

import java.util.Stack;

public class PalindromeIterative {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        LinkedListNode first = new LinkedListNode(0, null);
        LinkedListNode head = first;
        for (int i : arr) {
            LinkedListNode second = new LinkedListNode(i, null);
            first.setNext(second);
            first = second;
        }
        first.setNext(new LinkedListNode(0, null));
        System.out.println(head.printForward());
        System.out.println(isPalindrome(head));
    }

    private static boolean isPalindrome(LinkedListNode node) {
        LinkedListNode fast = node;
        LinkedListNode slow = node;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.getNext() != null) {
            stack.push(slow.getData());
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        if (fast != null) {
            slow = slow.getNext();
        }
        while (slow != null) {
            int top = stack.pop().intValue();
            if (top != slow.getData()) {
                return false;
            }
            slow = slow.getNext();
        }
        return true;
    }
}
