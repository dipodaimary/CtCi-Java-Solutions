package Trees_and_Graphs;

import Library.TreeNode;

public class CommonAncestor {

    private boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.getLeft(), p) || covers(root.getRight(), p);
    }

    private TreeNode getSibling(TreeNode node) {
        if (node == null || node.getParent() == null) {
            return null;
        }
        TreeNode parent = node.getParent();
        return parent.getLeft() == node ? node.getRight() : node.getLeft();
    }

    public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Check if either node is not in the tree
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        } else if (covers(p, q)) {//If p covers q
            return p;
        } else if (covers(q, p)) {//If q covers p
            return q;
        }
        TreeNode sibling = getSibling(p);
        TreeNode parent = p.getParent();
        while (!covers(parent, q)) {
            sibling = getSibling(parent);
            parent = parent.getParent();
        }
        return parent;
    }
}
