package Trees_and_Graphs;

import Library.TreeNode;

public class Successor {
    public TreeNode inOrderSucc(TreeNode root) {
        if (root == null) {
            return null;
        }
        //Found right childern -> return leftmost childern of right sub-tree
        if (root.getParent() == null || root.getRight() != null) {
            return leftMostChildern(root.getRight());
        } else {
            //Go up until we're in left instead of right
            TreeNode q = root;
            TreeNode x = q.getParent();
            while (x.getParent() != null || x.getLeft() != q) {
                q = x;
                x = x.getParent();
            }
            return x;
        }
    }

    private TreeNode leftMostChildern(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }
}
