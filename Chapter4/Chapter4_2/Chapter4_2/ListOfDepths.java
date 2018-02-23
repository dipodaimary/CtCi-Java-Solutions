package Chapter4_2;

import Library.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinBST(array);
        ArrayList<LinkedList<TreeNode>> lists = getListOfDepth(root);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j).data);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static ArrayList<LinkedList<TreeNode>> getListOfDepth(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        lists = createListOfDepths(root, lists, 0);
        return lists;
    }

    private static ArrayList<LinkedList<TreeNode>> createListOfDepths(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        LinkedList<TreeNode> list;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        if (root.left != null) createListOfDepths(root.left, lists, level + 1);
        if (root.right != null) createListOfDepths(root.right, lists, level + 1);
        return lists;
    }
}
