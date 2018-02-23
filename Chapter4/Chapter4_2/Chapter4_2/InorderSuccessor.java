package Chapter4_2;

import Library.TreeNode;

public class InorderSuccessor {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinBST(arr);
        System.out.println(Successor(root.right.left).data);
    }

    public static TreeNode Successor(TreeNode root) {
        if (root.right != null) {
            return leftMost(root.right);
        } else {
            TreeNode q = root;
            TreeNode x = q;
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    private static TreeNode leftMost(TreeNode right) {
        if (right == null) {
            return null;
        }
        while (right.left != null) {
            right = right.left;
        }
        return right;
    }
}
