package Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

import static Chapter4.MinTree.CreateMinBST;

public class ListOfDepthsRecursive {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = CreateMinBST(array);
        ArrayList<LinkedList<TreeNode>> lists = ListOfDepths(root);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j).getData());
            }
            System.out.println();
        }
    }

    public static ArrayList<LinkedList<TreeNode>> ListOfDepths(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) current.add(root);
        while (current.size() > 0) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for (TreeNode parent : parents) {
                if (parent.getLeft() != null) {
                    current.add(parent.getLeft());
                }
                if (parent.getRight() != null) {
                    current.add(parent.getRight());
                }
            }
        }
        return result;
    }
}
