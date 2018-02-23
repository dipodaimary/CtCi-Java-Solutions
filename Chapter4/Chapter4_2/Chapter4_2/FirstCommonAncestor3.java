package Chapter4_2;

import Library.TreeNode;

public class FirstCommonAncestor3 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinBST(arr);
        System.out.println(commonAncestor(root, root.left, root.left.left).data);
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

    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return root;
        }
        return commonAncestorHelper(root, p, q);
    }

    private static TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        boolean pOnLeft = covers(root.left, p);
        boolean qOnLeft = covers(root.left, q);
        if (pOnLeft != qOnLeft) {
            return root;
        }
        TreeNode childSubTree = pOnLeft ? root.left : root.right;
        return commonAncestor(childSubTree, p, q);
    }
}
