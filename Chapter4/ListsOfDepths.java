package Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

import static Chapter4.MinTree.CreateMinBST;

public class ListsOfDepths {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = CreateMinBST(array);
        ArrayList<LinkedList<TreeNode>> lists = createLevellinkedList(root);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j).getData());
            }
            System.out.println();
        }
    }

    public static ArrayList<LinkedList<TreeNode>> createLevellinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevellinkedList(root, lists, 0);
        return lists;
    }

    private static void createLevellinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> list = null;
        if (level == lists.size()) {
            list = new LinkedList<TreeNode>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        if (root.getLeft() != null) createLevellinkedList(root.getLeft(), lists, level + 1);
        if (root.getRight() != null) createLevellinkedList(root.getRight(), lists, level + 1);
    }
}
