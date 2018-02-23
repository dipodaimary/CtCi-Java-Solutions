package Chapter4_2;

import Library.TreeNode;

public class FirstCommonAncestor2 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinBST(arr);
        System.out.println(getFirstCommonAncestor(root, root.left, root.right).data);
    }

    public static boolean covers(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            return true;
        }
        return covers(root.left, p) || covers(root.right, p);
    }

    public static TreeNode getSibling(TreeNode node) {
        if (node == null || node.parent == null) {
            return null;
        }
        return node.parent.left == node ? node.parent.right : node.parent.left;
    }

    public static TreeNode getFirstCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        } else if (covers(p, q)) {
            return p;
        } else if (covers(q, p)) {
            return q;
        }
        TreeNode sibling = getSibling(p);
        TreeNode parent = p.parent;
        while (!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }
}
