package Trees_and_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        ListOfDepths listOfDepths = new ListOfDepths();
        ListOfDepths.TreeNode root = new ListOfDepths.TreeNode(5);
        root.setLeft(new ListOfDepths.TreeNode(3));
        root.setRight(new ListOfDepths.TreeNode(7));
        root.getLeft().setLeft(new ListOfDepths.TreeNode(1));
        root.getLeft().setRight(new ListOfDepths.TreeNode(2));
        root.getRight().setLeft(new ListOfDepths.TreeNode(6));
        root.getRight().setRight(new ListOfDepths.TreeNode(8));
        ArrayList<LinkedList<ListOfDepths.TreeNode>> lists = listOfDepths.getLevelLinkedList(root);
        for (LinkedList l : lists) {
            for (int i = 0; i < l.size(); i++) {
                ListOfDepths.TreeNode node = (ListOfDepths.TreeNode) l.get(i);
                System.out.print(node.getData() + " ");
            }
            System.out.println();
        }
    }
}
