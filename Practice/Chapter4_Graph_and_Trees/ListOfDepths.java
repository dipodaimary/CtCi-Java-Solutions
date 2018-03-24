package Trees_and_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {
    static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }
    }

    public ArrayList<LinkedList<TreeNode>> getLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    private void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> list = null;
        if (level == lists.size()) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        if (root.getLeft() != null) {
            createLevelLinkedList(root.getLeft(), lists, level + 1);
        }
        if (root.getRight() != null) {
            createLevelLinkedList(root.getRight(), lists, level + 1);
        }
    }
}
