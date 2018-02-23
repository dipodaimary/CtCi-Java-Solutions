package Chapter4_2;

import Library.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTSequence {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinBST(arr);
        ArrayList<LinkedList<Integer>> lists = allSequences(root);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void waveLists(LinkedList<Integer> first, LinkedList<Integer> second,
                                 ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            results.add(result);
            return;
        }
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        waveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);
        //do the same thing with the second
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        waveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }

    public static ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
        if (node == null) {
            result.add(new LinkedList<Integer>());
            return result;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.data);
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
        //Wave together each list from left to right
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> waved = new ArrayList<>();
                waveLists(left, right, waved, prefix);
                result.addAll(waved);
            }
        }
        return result;
    }
}
